package com.example.demo.config;

import java.util.ArrayList;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.demo.filter.TimeFilter;
import com.example.demo.interceptor.TimeInterceptor;
import com.example.demo.listener.ListenerTest;
import com.example.demo.servlet.OwnDefineServlet;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	
	
	@Autowired
	private TimeInterceptor timeInteceptor;
	/**
	 * 定义fastjson的Converter
	 * @return
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		
//		FastJsonConfig fastJsonConfig = new FastJsonConfig();
//		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		
//		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		
		HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
		
		return new HttpMessageConverters(converter);

	}
	
	/**
	 * 注册自定义的Servlet
	 * @return
	 */
	@Bean
	public ServletRegistrationBean   servletRegistrationBean() {
		return new ServletRegistrationBean<>(new OwnDefineServlet(),"/servletTest");
	}
	
	/**
	 * 注册自定义的filter
	 * @return
	 */
	@Bean
	public FilterRegistrationBean timeFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
		TimeFilter timeFilter = new TimeFilter();
		filterRegistrationBean.setFilter(timeFilter);
		
		ArrayList<String> urls = new ArrayList<>();
		urls.add("/*");
		filterRegistrationBean.setUrlPatterns(urls);
		return filterRegistrationBean;
	}
	/**
	 * 注册自定义的监听器
	 * @return
	 */
	
	@Bean
	public ServletListenerRegistrationBean<ListenerTest>  servletListenerRegistration(){
		return new ServletListenerRegistrationBean<ListenerTest>(new ListenerTest());
	}
	
	
	//编写拦截器后，我们还需要将其注册到拦截器链中，
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(timeInteceptor);
	}
	
	
	

}
