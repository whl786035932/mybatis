package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> getUserInfo() {
		List<User> findUserInfo = userMapper.findUserInfo();
		return findUserInfo;
	}

	@Transactional
	public void insert(User user) {
		userMapper.addUserInfo(user);
		int i=1/0;
		userMapper.addUserInfo(user);
	}

}
