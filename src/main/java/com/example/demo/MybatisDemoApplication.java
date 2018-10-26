package com.example.demo;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * https://blog.csdn.net/lgw96000/article/details/79776755
 * 演示mybatis  整合freemarker  thymeleaf  fastjosn 自定义Servlet   自定义过滤器
 * @author whl
 *
 */

@SpringBootApplication
public class MybatisDemoApplication  implements CommandLineRunner{
	
	@Autowired
	DataSource dataSource;
	
	public static void main(String[] args) {
		SpringApplication.run(MybatisDemoApplication.class, args);
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		System.out.println("DATASOURCE = " + dataSource);
	}
	
	
	
}
