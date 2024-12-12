package com.simpleboard.service;

import java.util.List;

import com.simpleboard.dto.Reply;

public interface ReplyService {
	List<Reply> getReplyListByPostnum(int postnum);
	void addReply(Reply reply);
	int deleteReply(int num);
	int modifyReply(Reply reply);
}
