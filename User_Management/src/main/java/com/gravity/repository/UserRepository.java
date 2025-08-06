package com.gravity.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gravity.model.User;

@Repository
public class UserRepository 
{
	public List<User> getUserList()
	{
		return List.of(new User(101, "BBD", "bbd@gmail.com"), new User(102, "Bibhu", "bibhu@gmail.com"), 
				new User(103, "Piyush", "piyush@gmail.com"));
	}
}
