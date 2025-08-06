package com.gravity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gravity.model.User;
import com.gravity.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepo;
		
	public List<User> getAllUsers()
	{
		return this.userRepo.getUserList();
	}
}
