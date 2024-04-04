package com.org.services;

import com.org.exceptions.ProductException;
import com.org.model.Cart;
import com.org.model.User;
import com.org.request.AddItemRequest;

public interface CartService {
	
	public Cart createCart(User user);
	
	public String addCartItem(Long userId, AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);

}
