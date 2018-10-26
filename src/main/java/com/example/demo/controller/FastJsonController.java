package com.example.demo.controller;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.User;

@Controller
@RequestMapping("fastjson")
public class FastJsonController {

	@RequestMapping(value="/hello")
	@ResponseBody
	public User test() {
		User user = new User();
		user.setAge(18);
		user.setName("wanghl");
		return user;
	}
}
