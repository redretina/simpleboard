package com.simpleboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.simpleboard.dao.ReplyDAO;
import org.springframework.stereotype.Service;

import com.simpleboard.dto.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDAO;

	@Override
	public List<Reply> getReplyListByPostnum(int postnum) {
		return replyDAO.selectReplyListByPostnum(postnum);
	}
	
	@Override
	public void addReply(Reply reply) {
		String content = reply.getContent();
		content = content.replace("\n", "<br>");
		reply.setContent(content);
		replyDAO.insertReply(reply);
	}
	
	@Override
	public int deleteReply(int num) {
		return replyDAO.deleteReply(num);
	}
	
	@Override
	public int modifyReply(Reply reply) {
		String content = reply.getContent();
		content = content.replace("\n", "<br>");
		reply.setContent(content);
		return replyDAO.updateReply(reply);
	}
}
