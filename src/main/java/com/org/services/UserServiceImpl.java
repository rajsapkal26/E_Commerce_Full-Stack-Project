package com.org.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.org.config.JwtProvider;
import com.org.exceptions.UserException;
import com.org.model.User;
import com.org.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	
	private UserRepository userRepo;
	private JwtProvider jwtProvider;
	
	
	public UserServiceImpl(UserRepository userRepo, JwtProvider jwtProvider) {
		this.userRepo=userRepo;
		this.jwtProvider = jwtProvider;
	}
	

	@Override
	public User findUserById(Long userId) throws UserException {

		Optional<User> user = userRepo.findById(userId);
		
		if(user.isPresent()) {
			return user.get();
		}
		
		throw new UserException("User Not Found with id = " + userId);
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {

		String email = jwtProvider.getEmailFromToken(jwt);
		
		User user = userRepo.findByEmail(email);
		
		if(user == null) {
		
			throw new UserException("User Not Found With Email = " + email);
		}
		
		return user;
	}

}
