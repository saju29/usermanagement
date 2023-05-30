package com.brooklet.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brooklet.usermanagement.dto.AuthenticationRequest;
import com.brooklet.usermanagement.entity.User;
import com.brooklet.usermanagement.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}

	@GetMapping("/displayActive")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String displayActiveUsers() {
		return "Display Users";
	}

	@GetMapping("/displayInactive")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String displayInactiveUsers() {
		return "Display Inactive Users";
	}

	@PostMapping("/new")
	public String addNewUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/list")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<User> listUsers() {
		return userService.listUsers();
	}

	@PostMapping("/authenticate")
	public String authenticate(@RequestBody AuthenticationRequest authenticationRequest) {

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			return "Success";
		}
		return "Invalid UserName/Password";

	}

}
