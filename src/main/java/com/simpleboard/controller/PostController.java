package com.simpleboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simpleboard.dto.Post;
import com.simpleboard.dto.Reply;
import com.simpleboard.service.PostService;
import com.simpleboard.service.ReplyService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping("/post_view/{num}")
	public String postView(@PathVariable int num, Model model) {
		model.addAttribute("post", postService.getPostByNum(num));
		model.addAttribute("replyList", replyService.getReplyListByPostnum(num));
		return "post_view";
	}
	
	@RequestMapping("/post_write")
	public String postWrite(Model model) {
		return "post_write";
	}
	
	@RequestMapping("/post_write_action")
	public String postWriteAction(@ModelAttribute Post post) {
		postService.writePost(post);
		return "redirect:/main";
	}
	
	@RequestMapping("/reply_write_action")
	public String replyWriteAction(@ModelAttribute Reply reply) {
		replyService.addReply(reply);
		return "redirect:/prev";
	}
	
	@RequestMapping("/reply_modify_action")
	public String replyModifyAction(@ModelAttribute Reply reply) {
		replyService.modifyReply(reply);
		return "redirect:/prev";
	}
	
	@RequestMapping("/reply_delete_action/{num}")
	public String replyDeleteAction(@PathVariable int num) {
		replyService.deleteReply(num);
		return "redirect:/prev";
	}
	
	@RequestMapping("/post_modify/{num}")
	public String postModify(@PathVariable int num, Model model) {
		Post post = postService.getPostByNum(num);
		model.addAttribute("post", post);
		return "post_modify";
	}
	
	@RequestMapping("/post_modify_action")
	public String postModifyAction(@ModelAttribute Post post) {
		postService.modifyPost(post);
		return "redirect:/post_view/"+post.getNum();
	}
	
	@RequestMapping("/post_delete_action/{num}")
	public String postDeleteAction(@PathVariable int num) {
		postService.deletePost(num);
		return "redirect:/main";
	}
}
