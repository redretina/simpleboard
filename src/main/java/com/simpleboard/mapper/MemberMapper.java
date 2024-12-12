package com.simpleboard.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.simpleboard.dto.Member;
import com.simpleboard.dto.Memberstate;

public interface MemberMapper {
	int insertMember(Member member);
	int updateMember(Member member);
	int deleteMember(String id);
	Member selectMemberById(String id);
	Member selectMemberByUsername(String username);
	int selectPostCountById(String id);
	int selectReplyCountById(String id);
	int updateLastLogin(String id);
	String selectStatenameById(String id);
	int selectMemberCount();
	List<Member> selectAllMemberList(Map<String, Object> map);
	int selectAllMemberCount();
	List<Memberstate> selectAllMemberstateList();
}
