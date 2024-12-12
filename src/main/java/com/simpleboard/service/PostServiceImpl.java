package com.simpleboard.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleboard.dao.PostDAO;
import com.simpleboard.dto.Post;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDAO postDAO;
	
	@Override
	public int getPostCount(Map<String, Object> postMap) {
		return postDAO.selectPostCount(postMap);
	}
	
	@Override
	public List<Post> getPostList(Map<String, Object> postMap) {
		return postDAO.selectPostList(postMap);
	}
	
	@Override
	public Post getPostByNum(int num) {
		return postDAO.selectPostByNum(num);
	}
	
	@Override
	public int writePost(Post post) {
		String content = post.getContent();
		content = content.replace("\n", "<br>");
		post.setContent(content);
		return postDAO.insertPost(post);
	}
	
	@Override
	public int modifyPost(Post post) {
		String content = post.getContent();
		content = content.replace("\n", "<br>");
		post.setContent(content);
		return postDAO.updatePost(post);
	}
	
	@Override
	public int deletePost(int num) {
		return postDAO.deletePost(num);
	}
}
