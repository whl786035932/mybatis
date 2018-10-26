package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="getUserInfo")
	@ResponseBody
	public List<User> getUserInfo(){
		List<User> userInfo = userService.getUserInfo();
		return userInfo;
	}

	
	@RequestMapping(value="addUserInfo")
	@ResponseBody
	public String addUserInfo() {
		User user = new User();
		user.setAge(18);
		user.setName("whl");
		userService.insert(user);
		return "success:"+user.toString();
	}
	
	
}
