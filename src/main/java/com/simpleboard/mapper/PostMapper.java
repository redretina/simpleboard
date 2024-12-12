package com.simpleboard.mapper;

import java.util.List;
import java.util.Map;

import com.simpleboard.dto.Post;

public interface PostMapper {
	int selectPostCount(Map<String, Object> map);
	int insertPost(Post post);
	int updatePost(Post post);
	int deletePost(int num);
	Post selectPostByNum(int num);
	List<Post> selectPostList(Map<String, Object> map);
}
