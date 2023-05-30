package com.brooklet.usermanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.brooklet.usermanagement.entity.User;
import com.brooklet.usermanagement.repository.UserRepository;

@Component
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUserName(username);
		UserDetails userDetails = user.map(MyUserDetails::new)
		.orElseThrow(()->new UsernameNotFoundException("User Not Found "+username));
			return userDetails;
	}

}
