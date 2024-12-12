package com.simpleboard.service;

import java.util.List;
import java.util.Map;

import com.simpleboard.dto.Post;

public interface PostService {
	int getPostCount(Map<String, Object> postMap);
	List<Post> getPostList(Map<String, Object> postMap);
	Post getPostByNum(int num);
	int writePost(Post post);
	int modifyPost(Post post);
	int deletePost(int num);
}
