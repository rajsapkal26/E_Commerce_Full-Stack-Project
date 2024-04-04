package com.org.services;

import com.org.exceptions.UserException;
import com.org.model.User;



public interface UserService {

	public User findUserById(Long userId)throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;
	
}
