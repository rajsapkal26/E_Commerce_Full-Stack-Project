package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.exceptions.UserException;
import com.org.model.User;
import com.org.repository.UserRepository;
import com.org.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
	
	@GetMapping("/profile")
	public ResponseEntity<User> getUserProfileHandler(@RequestHeader("Authorization")String jwt)
														throws UserException{
		
		User user = userService.findUserProfileByJwt(jwt);
		
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
		
	}

}
