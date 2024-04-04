package com.org.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.org.model.User;
import com.org.repository.UserRepository;

@Service
public class CustomeUserServiceImpl implements UserDetailsService {

	
	private UserRepository userRepo;
	
	public CustomeUserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByEmail(username);
		
		
		if(user==null) {
			throw new UsernameNotFoundException("User Not Found with email = " + username);
		};
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

	
	
}
