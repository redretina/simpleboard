package com.simpleboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simpleboard.dto.Post;
import com.simpleboard.mapper.PostMapper;

@Repository
public class PostDAOImpl implements PostDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int selectPostCount(Map<String, Object> map) {
		return sqlSession.getMapper(PostMapper.class).selectPostCount(map);
	}
	
	@Override
	public List<Post> selectPostList(Map<String, Object> map) {
		return sqlSession.getMapper(PostMapper.class).selectPostList(map);
	}
	
	@Override
	public Post selectPostByNum(int num) {
		return sqlSession.getMapper(PostMapper.class).selectPostByNum(num);
	}
	
	@Override
	public int insertPost(Post post) {
		return sqlSession.getMapper(PostMapper.class).insertPost(post);
	}
	
	@Override
	public int updatePost(Post post) {
		return sqlSession.getMapper(PostMapper.class).updatePost(post);
	}
	
	@Override
	public int deletePost(int num) {
		return sqlSession.getMapper(PostMapper.class).deletePost(num);
	}
}
