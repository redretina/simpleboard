package com.simpleboard.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("prevURLInterceptor")
public class PrevURLInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String prevURL = request.getHeader("referer");
		request.getSession().setAttribute("prevURL", prevURL);
		return true;
	}
	
}
