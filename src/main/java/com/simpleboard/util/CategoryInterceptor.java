package com.simpleboard.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.simpleboard.dto.Category;
import com.simpleboard.service.CategoryService;

@Component("categoryInterceptor")
public class CategoryInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private CategoryService categoryService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("categoryList") == null) {
			List<Category> categoryList = categoryService.getCategoryList();
			session.setAttribute("categoryList", categoryList);
		}
		return true;
	}
	
}
