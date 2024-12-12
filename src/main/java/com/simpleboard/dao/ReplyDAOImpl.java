package com.simpleboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simpleboard.dto.Reply;
import com.simpleboard.mapper.ReplyMapper;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Reply> selectReplyListByPostnum(int postnum) {
		return sqlSession.getMapper(ReplyMapper.class).selectReplyListByPostnum(postnum);
	}
	
	@Override
	public int insertReply(Reply reply) {
		return sqlSession.getMapper(ReplyMapper.class).insertReply(reply);
	}
	
	@Override
	public int deleteReply(int num) {
		return sqlSession.getMapper(ReplyMapper.class).deleteReply(num);
	}
	
	@Override
	public int updateReply(Reply reply) {
		return sqlSession.getMapper(ReplyMapper.class).updateReply(reply);
	}
	
	@Override
	public int selectReplyCount() {
		return sqlSession.getMapper(ReplyMapper.class).selectReplyCount();
	}
}
