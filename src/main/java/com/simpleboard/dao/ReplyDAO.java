package com.simpleboard.dao;

import java.util.List;

import com.simpleboard.dto.Category;
import com.simpleboard.dto.Reply;

public interface ReplyDAO {
	List<Reply> selectReplyListByPostnum(int postnum);
	int insertReply(Reply reply);
	int deleteReply(int num);
	int updateReply(Reply reply);
	int selectReplyCount();
}
