package com.simpleboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simpleboard.dto.Member;
import com.simpleboard.dto.Memberstate;
import com.simpleboard.mapper.MemberMapper;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public Member selectMemberById(String id) {
		return sqlSession.getMapper(MemberMapper.class).selectMemberById(id);
	}
	
	@Override
	public Member selectMemberByUsername(String username) {
		return sqlSession.getMapper(MemberMapper.class).selectMemberByUsername(username);
	}
	
	@Override
	public int insertMember(Member member) {
		return sqlSession.getMapper(MemberMapper.class).insertMember(member);
	}
	
	@Override
	public int deleteMember(String id) {
		return sqlSession.getMapper(MemberMapper.class).deleteMember(id);
	}
	
	@Override
	public int updateMember(Member member) {
		return sqlSession.getMapper(MemberMapper.class).updateMember(member);
	}
	
	@Override
	public int selectPostCountById(String id) {
		return sqlSession.getMapper(MemberMapper.class).selectPostCountById(id);
	}
	
	@Override
	public int selectReplyCountById(String id) {
		return sqlSession.getMapper(MemberMapper.class).selectReplyCountById(id);
	}
	
	@Override
	public int updateLastLogin(String id) {
		return sqlSession.getMapper(MemberMapper.class).updateLastLogin(id);
	}
	
	@Override
	public String selectStatenameById(String id) {
		return sqlSession.getMapper(MemberMapper.class).selectStatenameById(id);
	}
	
	@Override
	public int selectMemberCount() {
		return sqlSession.getMapper(MemberMapper.class).selectMemberCount();
	}
	
	@Override
	public List<Member> selectAllMemberList(Map<String, Object> map) {
		return sqlSession.getMapper(MemberMapper.class).selectAllMemberList(map);
	}
	
	@Override
	public int selectAllMemberCount() {
		return sqlSession.getMapper(MemberMapper.class).selectAllMemberCount();
	}
	
	@Override
	public List<Memberstate> selectAllMemberstateList() {
		return sqlSession.getMapper(MemberMapper.class).selectAllMemberstateList();
	}
}
