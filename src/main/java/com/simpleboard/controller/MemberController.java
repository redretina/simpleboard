package com.simpleboard.controller;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simpleboard.dto.Member;
import com.simpleboard.exception.BadRequestException;
import com.simpleboard.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping("/loginCheck")
	@ResponseBody
	public String login(@RequestParam String id, @RequestParam String password) {
		Member member = memberService.getMemberById(id);
		if(member == null) return "noId";
		if(BCrypt.checkpw(password, member.getPassword())) {
			if(member.getState()==2) {
				return "withdraw";
			} 
			return "success";
		} else {
			return "fail";
		}
	}
	
	@RequestMapping("/login_action")
	public String loginAction(@RequestParam String id, HttpSession session) {
		memberService.updateLastLogin(id);
		Member loginMember = memberService.getMemberById(id);
		session.setAttribute("loginMember", loginMember);
		return "redirect:/main";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.setAttribute("loginMember", null);
		return "redirect:/main";
	}
	
	@RequestMapping("/join")
	public String join(Model model) {
		return "join";
	}
	
	@ResponseBody
	@RequestMapping("/joinCheck")
	public String joinCheck(@RequestParam String id, @RequestParam String username) {
		if(memberService.getMemberById(id) != null) {
			return "idExist";
		} else if(memberService.getMemberByUsername(username) != null) {
			return "usernameExist";
		}
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("/usernameCheck")
	public String usernameCheck(@RequestParam String username, @RequestParam String checkUsername) {
		if(!checkUsername.equals(username)) {
			if(memberService.getMemberByUsername(username) != null) {
				return "usernameExist";
			}
		}
		return "success";
	}
	
	@RequestMapping("/join_action")
	public String joinAction(@ModelAttribute Member member) {
		memberService.addMember(member);
		return "join_ok";
	}
	
	@RequestMapping("/mypage")
	public String mypage(HttpSession session) {
		Member loginMember = (Member)session.getAttribute("loginMember");
		loginMember.setPostCount(memberService.getPostCountById(loginMember.getId()));
		loginMember.setReplyCount(memberService.getReplyCountById(loginMember.getId()));
		loginMember.setStatename(memberService.getStatenameById(loginMember.getId()));
		session.setAttribute("loginMember", loginMember);
		return "mypage";
	}
	
	@RequestMapping("/member_modify")
	public String memberModify(Model model) {
		return "member_modify";
	}
	
	@RequestMapping("/member_modify_action")
	public String memberModifyAction(@ModelAttribute Member member, HttpSession session) {
		memberService.modifyMember(member);
		session.setAttribute("loginMember", null);
		return "member_modify_ok";
	}
	
	@RequestMapping("/member_withdraw")
	public String memberWithdraw(HttpSession session, Model model) {
		Member loginMember = (Member)session.getAttribute("loginMember");
		memberService.removeMember(loginMember.getId());
		session.setAttribute("loginMember", null);
		return "redirect:/main";
	}
}
