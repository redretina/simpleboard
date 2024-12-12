package com.simpleboard.service;

import java.util.List;
import java.util.Map;

import com.simpleboard.dto.Category;
import com.simpleboard.dto.Member;
import com.simpleboard.dto.Memberstate;

public interface AdminService {
	int getMemberCount();
	int getPostCount();
	int getReplyCount();
	int getCategoryCount();
	List<Member> getAllMemberList(Map<String, Object> map);
	int getAllMemberCount();
	List<Memberstate> getAllMemberstateList();
	Category getCategoryByName(String name);
	int addCategory(Category category);
	int modifyCategory(Category category);
	int deleteCategory(int num);
}