package com.example.demo.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class User  implements Serializable{

	private Integer id;
	@JSONField(name="nickname")
	private String name;
	private Integer age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
