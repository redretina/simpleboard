package com.simpleboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simpleboard.dto.Category;
import com.simpleboard.dto.Member;
import com.simpleboard.service.AdminService;
import com.simpleboard.service.CategoryService;
import com.simpleboard.service.MemberService;
import com.simpleboard.util.Pager;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/main")
	public String adminMain(Model model) {
		model.addAttribute("memberCount", adminService.getMemberCount());
		model.addAttribute("postCount", adminService.getPostCount());
		model.addAttribute("replyCount", adminService.getReplyCount());
		return "admin/main";
	}
	
	@RequestMapping("/member_list")
	public String adminMember(Model model, HttpServletRequest request) {
		int totalObject = adminService.getAllMemberCount();
		int blockSize = 5;
		int pageSize = 5;
		int pageNum = 1;
		if(request.getParameter("pageNum")!=null && !request.getParameter("pageNum").equals("")) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		Pager pager = new Pager(pageNum, totalObject, pageSize, blockSize);
		Map<String, Object> memberMap = new HashMap<String, Object>();
		memberMap.put("startRow", pager.getStartRow());
		memberMap.put("endRow", pager.getEndRow());
		List<Member> memberList = adminService.getAllMemberList(memberMap);
		model.addAttribute("memberList", memberList);
		model.addAttribute("pager", pager);
		model.addAttribute("pageNum", pageNum);
		return "admin/member_list";
	}
	
	@RequestMapping("/member_detail/{id}")
	public String adminMemberDetail(@PathVariable String id, Model model) {
		model.addAttribute("member", memberService.getMemberById(id));
		model.addAttribute("memberstateList", adminService.getAllMemberstateList());
		return "admin/member_detail";
	}
	
	@RequestMapping("/member_detail_action")
	public String adminMemberDetailAction(@ModelAttribute Member member, Model model) {
		memberService.modifyMember(member);
		return "redirect:/admin/member_list";
	}
	
	@RequestMapping("/category")
	public String adminCategory(HttpServletRequest request, Model model) {
		model.addAttribute("categoryList", categoryService.getCategoryList());
		int totalObject = adminService.getCategoryCount();
		int blockSize = 5;
		int pageSize = 5;
		int pageNum = 1;
		if(request.getParameter("pageNum")!=null && !request.getParameter("pageNum").equals("")) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		Pager pager = new Pager(pageNum, totalObject, pageSize, blockSize);
		Map<String, Object> categoryMap = new HashMap<String, Object>();
		categoryMap.put("startRow", pager.getStartRow());
		categoryMap.put("endRow", pager.getEndRow());
		return "admin/category";
	}
	
	@ResponseBody
	@RequestMapping("/categoryCheck")
	public String adminCategoryCheck(@RequestParam String name, Model model) {
		Category categoryCheck = adminService.getCategoryByName(name);
		if(categoryCheck != null) {
			return "categoryExist";
		}
		return "success";
	}
	
	@RequestMapping("/category_add_action")
	public String adminCategoryAdd(@ModelAttribute Category category, Model model) {
		adminService.addCategory(category);
		return "redirect:/admin/category";
	}
	
	@RequestMapping("/category_modify_action")
	public String adminCategoryModifyAction(@ModelAttribute Category category, Model model) {
		adminService.modifyCategory(category);
		return "redirect:/admin/category";
	}
	
	@RequestMapping("/category_delete_action")
	public String adminCategoryDeleteAction(@ModelAttribute int num, Model model) {
		adminService.deleteCategory(num);
		return "redirect:/admin/category";
	}
}