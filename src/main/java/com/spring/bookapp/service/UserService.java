package com.spring.bookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bookapp.model.User;
import com.spring.bookapp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User getUser(String userName, String password) {
		User user = userRepository.findByUserName(userName);
		if(user == null) {
			user = new User(userName, password);
			user = userRepository.save(user);
		}
		return user;
	}
}
