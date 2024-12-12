package com.simpleboard.dao;

import java.util.List;
import java.util.Map;

import com.simpleboard.dto.Post;

public interface PostDAO {
	int selectPostCount(Map<String, Object> map);
	List<Post> selectPostList(Map<String, Object> map);
	Post selectPostByNum(int num);
	int insertPost(Post post);
	int updatePost(Post post);
	int deletePost(int num);
}
