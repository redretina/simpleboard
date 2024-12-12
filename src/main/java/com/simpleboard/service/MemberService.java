package com.simpleboard.service;

import com.simpleboard.dto.Member;

public interface MemberService {
	Member getMemberById(String id);
	Member getMemberByUsername(String username);
	void addMember(Member member);
	int removeMember(String id);
	int modifyMember(Member member);
	int getPostCountById(String id);
	int getReplyCountById(String id);
	int updateLastLogin(String id);
	String getStatenameById(String id);
}
