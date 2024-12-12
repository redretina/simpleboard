package com.simpleboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simpleboard.dto.Post;
import com.simpleboard.service.CategoryService;
import com.simpleboard.service.PostService;
import com.simpleboard.util.Pager;

@Controller
public class MainController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/main")
	public String main(HttpServletRequest request, Model model) {
		int categoryNum = 0;
		String categoryName = "";
		String searchKeyword = "";
		
		if(request.getParameter("categoryNum")!=null && request.getParameter("categoryNum") != "0") {
			categoryNum = Integer.parseInt(request.getParameter("categoryNum"));
			categoryName = categoryService.getCategoryNameByNum(categoryNum);
		}
		if(request.getParameter("searchKeyword")!=null) {
			searchKeyword = request.getParameter("searchKeyword");
		}
		Map<String, Object> postMap = new HashMap<String, Object>();
		postMap.put("categoryNum", categoryNum);
		postMap.put("searchKeyword", searchKeyword);
		int totalObject = postService.getPostCount(postMap);
		int blockSize = 5;
		int pageSize = 5;
		int pageNum = 1;
		if(request.getParameter("pageNum")!=null && !request.getParameter("pageNum").equals("")) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		Pager pager = new Pager(pageNum, totalObject, pageSize, blockSize);
		postMap.put("startRow", pager.getStartRow());
		postMap.put("endRow", pager.getEndRow());
		List<Post> postList = postService.getPostList(postMap);
		
		model.addAttribute("postList", postList);
		model.addAttribute("pager", pager);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("categoryNum", categoryNum);
		model.addAttribute("categoryName", categoryName);
		model.addAttribute("searchKeyword", searchKeyword);

		return "main";
	}
	
	@RequestMapping
	public String none() {
		return "redirect:/main";
	}
	
	@RequestMapping("/prev")
	public String prev(HttpSession session) {
		return "redirect:"+session.getAttribute("prevURL");
	}
}
