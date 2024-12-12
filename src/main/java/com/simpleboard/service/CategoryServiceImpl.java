package com.simpleboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleboard.dao.CategoryDAO;
import com.simpleboard.dto.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public List<Category> getCategoryList() {
		return categoryDAO.selectCategoryList();
	}
	
	@Override
	public String getCategoryNameByNum(int num) {
		return categoryDAO.selectCategoryNameByNum(num);
	}
}
