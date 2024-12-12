package com.simpleboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simpleboard.dto.Category;
import com.simpleboard.mapper.CategoryMapper;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertCategory(Category category) {
		return sqlSession.getMapper(CategoryMapper.class).insertCategory(category);
	}
	
	@Override
	public int updateCategory(Category category) {
		return sqlSession.getMapper(CategoryMapper.class).updateCategory(category);
	}
	
	@Override
	public int deleteCategory(int num) {
		return sqlSession.getMapper(CategoryMapper.class).deleteCategory(num);
	}
	
	@Override
	public List<Category> selectCategoryList() {
		return sqlSession.getMapper(CategoryMapper.class).selectCategoryList();
	}
	
	@Override
	public String selectCategoryNameByNum(int num) {
		return sqlSession.getMapper(CategoryMapper.class).selectCategoryNameByNum(num);
	}
	
	@Override
	public int selectCategoryCount() {
		return sqlSession.getMapper(CategoryMapper.class).selectCategoryCount();
	}
	
	@Override
	public Category selectCategoryByName(String name) {
		return sqlSession.getMapper(CategoryMapper.class).selectCategoryByName(name);
	}
}
