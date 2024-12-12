package com.simpleboard.service;

import java.util.List;

import com.simpleboard.dto.Category;

public interface CategoryService {
	List<Category> getCategoryList();
	String getCategoryNameByNum(int num);
}
