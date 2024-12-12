package com.simpleboard.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleboard.dao.CategoryDAO;
import com.simpleboard.dao.MemberDAO;
import com.simpleboard.dao.PostDAO;
import com.simpleboard.dao.ReplyDAO;
import com.simpleboard.dto.Category;
import com.simpleboard.dto.Member;
import com.simpleboard.dto.Memberstate;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public int getMemberCount() {
		return memberDAO.selectMemberCount();
	}
	
	@Override
	public int getPostCount() {
		return postDAO.selectPostCount(null);
	}
	
	@Override
	public int getReplyCount() {
		return replyDAO.selectReplyCount();
	}
	
	@Override
	public int getCategoryCount() {
		return categoryDAO.selectCategoryCount();
	}
	
	@Override
	public List<Member> getAllMemberList(Map<String, Object> map) {
		return memberDAO.selectAllMemberList(map);
	}
	
	@Override
	public int getAllMemberCount() {
		return memberDAO.selectAllMemberCount();
	}
	
	@Override
	public List<Memberstate> getAllMemberstateList() {
		return memberDAO.selectAllMemberstateList();
	}
	
	@Override
	public Category getCategoryByName(String name) {
		return categoryDAO.selectCategoryByName(name);
	}
	
	@Override
	public int addCategory(Category category) {
		return categoryDAO.insertCategory(category);
	}
	
	@Override
	public int modifyCategory(Category category) {
		return categoryDAO.updateCategory(category);
	}
	
	@Override
	public int deleteCategory(int num) {
		return categoryDAO.deleteCategory(num);
	}
}
