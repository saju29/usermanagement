package com.brooklet.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.brooklet.usermanagement.entity.User;
import com.brooklet.usermanagement.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;


	public String addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "User added successfully";
	}
	
	public List<User> listUsers(){
		List<User> users = userRepository.findAll();
		return userRepository.findAll();
	}
}
