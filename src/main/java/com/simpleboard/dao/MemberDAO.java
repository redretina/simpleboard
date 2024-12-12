package com.simpleboard.dao;

import java.util.List;
import java.util.Map;

import com.simpleboard.dto.Member;
import com.simpleboard.dto.Memberstate;

public interface MemberDAO {
	Member selectMemberById(String id);
	Member selectMemberByUsername(String username);
	int insertMember(Member member);
	int deleteMember(String id);
	int updateMember(Member member);
	int selectPostCountById(String id);
	int selectReplyCountById(String id);
	int updateLastLogin(String id);
	String selectStatenameById(String id);
	int selectMemberCount();
	List<Member> selectAllMemberList(Map<String, Object> map);
	int selectAllMemberCount();
	List<Memberstate> selectAllMemberstateList();
}
