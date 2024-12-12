package com.simpleboard.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleboard.dao.MemberDAO;
import com.simpleboard.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public Member getMemberById(String id) {
		return memberDAO.selectMemberById(id);
	}

	@Override
	public Member getMemberByUsername(String username) {
		return memberDAO.selectMemberByUsername(username);
	}
	
	@Override
	public void addMember(Member member) {
		String password = member.getPassword();
		member.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
		memberDAO.insertMember(member);
	}
	
	@Override
	public int removeMember(String id) {
		return memberDAO.deleteMember(id);
	}
	
	@Override
	public int modifyMember(Member member) {
		if(member.getPassword() != null && !member.getPassword().equals("")) {
			String password = member.getPassword();
			member.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
		}
		return memberDAO.updateMember(member);
	}
	
	@Override
	public int getPostCountById(String id) {
		return memberDAO.selectPostCountById(id);
	}
	
	@Override
	public int getReplyCountById(String id) {
		return memberDAO.selectReplyCountById(id);
	}
	
	@Override
	public int updateLastLogin(String id) {
		return memberDAO.updateLastLogin(id);
	}
	
	@Override
	public String getStatenameById(String id) {
		return memberDAO.selectStatenameById(id);
	}
}
