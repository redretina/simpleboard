package com.simpleboard.dao;

import java.util.List;

import com.simpleboard.dto.Category;

public interface CategoryDAO {
	int insertCategory(Category category);
	int updateCategory(Category category);
	int deleteCategory(int num);
	List<Category> selectCategoryList();
	String selectCategoryNameByNum(int num);
	int selectCategoryCount();
	Category selectCategoryByName(String name);
}
