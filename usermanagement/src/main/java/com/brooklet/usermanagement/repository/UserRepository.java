package com.brooklet.usermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brooklet.usermanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUserName(String username);
	
//	@Query("SELECT new com.brooklet.usermanagement.entity.User(user.id, user.userFirstName) FROM User user")
//	List<User> findAll();
}
