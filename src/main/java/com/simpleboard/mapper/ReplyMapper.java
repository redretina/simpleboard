package com.simpleboard.mapper;

import java.util.List;

import com.simpleboard.dto.Reply;

public interface ReplyMapper {
	int insertReply(Reply reply);
	int updateReply(Reply reply);
	int deleteReply(int num);
	List<Reply> selectReplyListByPostnum(int postNum);
	List<Reply> selectReplyListByWriter(String writer);
	Reply selectReplyByNum(int num);
	int selectReplyCount();
}