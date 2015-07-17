package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//요청필터
		System.out.println("EncodingFilter 요청필터");
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response); // 다음 필터 또는 서블릿으로 요청한다.
		
		//응답필터
		System.out.println("EncodingFilter 응답필터");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
