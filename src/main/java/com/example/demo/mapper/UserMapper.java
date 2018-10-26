package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

@Component
@Mapper
public interface UserMapper {
	public List<User> findUserInfo();
	
	public int addUserInfo(User user);
	
	public int delUserInfo(int id);
}
