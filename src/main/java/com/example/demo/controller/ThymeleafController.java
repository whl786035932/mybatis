package com.example.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="thymeleaf")
public class ThymeleafController {

	@RequestMapping(value="hello")
	public String hello(Map<String,Object> map) {
		map.put("msg", "springboot  整合thymeleaf success");
		return "hello";
	}
	
}
