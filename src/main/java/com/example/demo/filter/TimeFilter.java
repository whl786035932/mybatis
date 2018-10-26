package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

//@Component  自定义的过滤器可以通过@Component生效，也可以注册到WebConfig
public class TimeFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("销毁过滤器");
	}

	@Override
	public void doFilter(ServletRequest request	, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		long currentTimeMillis = System.currentTimeMillis();
		filterChain.doFilter(request, response);
		System.out.println("filter 耗时="+(System.currentTimeMillis()-currentTimeMillis));	
		}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化filter");
	}

	

}

