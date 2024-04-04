package com.org.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.config.JwtProvider;
import com.org.exceptions.UserException;
import com.org.model.Cart;
import com.org.model.User;
import com.org.repository.UserRepository;
import com.org.request.LoginRequest;
import com.org.response.AuthResponse;
import com.org.services.CartService;
import com.org.services.CustomeUserServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	
	private UserRepository userRepo;
	private JwtProvider jwtProvider;
	private PasswordEncoder passwordEncoder;
	private CustomeUserServiceImpl customeUserServiceImpl;
	private CartService cartService;
	
	public AuthController(UserRepository userRepo, CustomeUserServiceImpl customeUserServiceImpl,
					PasswordEncoder passwordEncoder, JwtProvider jwtProvider, CartService cartService) {
		this.userRepo = userRepo;
		this.customeUserServiceImpl = customeUserServiceImpl;
		this.passwordEncoder = passwordEncoder;
		this.jwtProvider =jwtProvider;
		this.cartService = cartService;
	}
	
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse>createUserHandler(@RequestBody User user) throws UserException{
		
		String email = user.getEmail();
		String password = user.getPassword();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		
		
		User isEmailExist = userRepo.findByEmail(email);
		
		if(isEmailExist != null) {
			throw new UserException("Email is Already used with another Account");
		}
		
		
		
		
		User CreatedUser = new User();
		CreatedUser.setEmail(email);
		CreatedUser.setPassword(passwordEncoder.encode(password));
		CreatedUser.setFirstName(firstName);
		CreatedUser.setLastName(lastName);
		
		
		User SavedUser = userRepo.save(CreatedUser);
		Cart cart = cartService.createCart(SavedUser);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(SavedUser.getEmail(), SavedUser.getPassword());
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtProvider.generateToken(authentication);
		
		AuthResponse authResponse = new AuthResponse();
		
		authResponse.setJwt(token);
		authResponse.setMessage("signUp Success");
		
		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
		
	}

	@PostMapping("signin")
	public ResponseEntity<AuthResponse>loginUserHandler(@RequestBody LoginRequest loginRequest){
		
		
		String username = loginRequest.getEmail();
		String password = loginRequest.getPassword();
		
		Authentication authenticaiton = authenticate(username, password);
		
		SecurityContextHolder.getContext().setAuthentication(authenticaiton);
		
		String token = jwtProvider.generateToken(authenticaiton);
		
		AuthResponse authResponse = new AuthResponse();
		
		authResponse.setJwt(token);
		authResponse.setMessage("signin Success");
		
		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
		
	}

	
	
	private Authentication authenticate(String username, String password) {

		UserDetails userDetails = customeUserServiceImpl.loadUserByUsername(username);
		
		if(userDetails==null) {
			throw new BadCredentialsException("Invalid Username...");
		}
		
		if(!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("Inavalid Password...");
		}
		
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}
}
