package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
		
	public User findByEmail(String email);

}
