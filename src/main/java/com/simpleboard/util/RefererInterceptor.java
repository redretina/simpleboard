package com.simpleboard.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.simpleboard.exception.BadRequestException;

@Component("refererInterceptor")
public class RefererInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getHeader("referer") == null) {
			throw new BadRequestException();
		}
		return true;
	}
	
}
