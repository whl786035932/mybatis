package com.example.demo;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import com.example.demo.filter.TimeFilter;
import com.example.demo.listener.ListenerTest;
import com.example.demo.servlet.OwnDefineServlet;
/**
 * https://blog.csdn.net/lgw96000/article/details/79776755
 * 针对自定义 Servlet、Filter 和 Listener 的配置，还有另一种方式：
 * @author whl
 *
 */
@SpringBootApplication
public class SpringBootWebApplicaton implements ServletContextInitializer {
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	// 配置 Servlet
        servletContext.addServlet("servletTest",new OwnDefineServlet())
        			  .addMapping("/servletTest");
        // 配置过滤器
        servletContext.addFilter("timeFilter",new TimeFilter())
        			  .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");
        // 配置监听器
        servletContext.addListener(new ListenerTest());
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplicaton.class, args);
	}
}

