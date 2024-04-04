package com.org.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.org.exceptions.CartItemException;
import com.org.exceptions.UserException;
import com.org.model.Cart;
import com.org.model.CartItem;
import com.org.model.Product;
import com.org.model.User;
import com.org.repository.CartItemRepository;
import com.org.repository.CartRepository;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	
	private CartItemRepository cartItemRepo;
	private UserService userService;
	private CartRepository cartRepo;
	
	
	public CartItemServiceImpl(CartItemRepository cartItemRepo,UserService userService, 
								CartRepository cartRepo ) {
		
		this.cartItemRepo = cartItemRepo;
		this.userService = userService;
		this.cartRepo = cartRepo;
		
	}
	

	@Override
	public CartItem createCartItem(CartItem cartItem) {
		
		cartItem.setQuantity(1);
		cartItem.setPrice(cartItem.getProduct().getDiscountedPrice()*cartItem.getQuantity());
		cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice()*cartItem.getQuantity());
		
		
		CartItem createdCartItem = cartItemRepo.save(cartItem);
		
		
		return createdCartItem;
	}

	@Override
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {
		
		CartItem item = findCartItemById(id);
		User user = userService.findUserById(item.getUserId());
		
		if(user.getId().equals(userId)) {
			item.setQuantity(cartItem.getQuantity());
			item.setPrice(item.getQuantity()*item.getProduct().getPrice());
			item.setDiscountedPrice(item.getProduct().getDiscountedPrice()*item.getQuantity());
		}
		
		
		return cartItemRepo.save(item);
	}

	@Override
	public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
		
		
		CartItem cartItem = cartItemRepo.isCartItemExist(cart, product, size, userId);
		
		return cartItem;
	}

	@Override
	public void removeCartitem(Long userId, Long cartItemId) throws CartItemException, UserException {
		
		CartItem cartItem=findCartItemById(cartItemId);
		
		User user = userService.findUserById(cartItem.getUserId());
		
		User reqUser = userService.findUserById(userId);
		
		if(user.getId().equals(reqUser.getId())) {
			cartItemRepo.deleteById(cartItemId);
		}else {
			
			throw new UserException("you Cant remove another users item");
		}
		
	}

	@Override
	public CartItem findCartItemById(Long cartItemId) throws CartItemException {

		Optional<CartItem> opt = cartItemRepo.findById(cartItemId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		
		throw new CartItemException("Cart Item Not Find with id := " + cartItemId);
	}

}
