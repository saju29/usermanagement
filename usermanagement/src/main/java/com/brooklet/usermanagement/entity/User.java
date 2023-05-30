package com.brooklet.usermanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private String userFirstName;
	private String userLastName;
	private String userName;
	private String password;
	private String roles;
	
	public User(int id,String userFirstName) {
		this.id = id;
		this.userFirstName = userFirstName;
	}
}

