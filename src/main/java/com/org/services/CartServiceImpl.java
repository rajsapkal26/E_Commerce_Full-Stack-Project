package com.org.services;

import org.springframework.stereotype.Service;

import com.org.exceptions.ProductException;
import com.org.model.Cart;
import com.org.model.CartItem;
import com.org.model.Product;
import com.org.model.User;
import com.org.repository.CartRepository;
import com.org.request.AddItemRequest;

@Service
public class CartServiceImpl implements CartService {

	private CartRepository cartRepo;
	private CartItemService cartItemService;
	private ProductService productService;
	
	public CartServiceImpl(CartRepository cartRepo, CartItemService cartItemService, 
							ProductService productService) {

		this.cartRepo =cartRepo;
		this.cartItemService = cartItemService;
		this.productService = productService;
	
	}
	
	
	@Override
	public Cart createCart(User user) {

		Cart cart = new Cart();
		cart.setUser(user);
		
		
		return cartRepo.save(cart);
	}

	@Override
	public String addCartItem(Long userId, AddItemRequest req) throws ProductException {

		Cart cart = cartRepo.findByUserId(userId);
		Product product = productService.findProductById(req.getPriductId());
		
		CartItem isPresent = cartItemService.isCartItemExist(cart, product, req.getSize(), userId);
		
		if(isPresent == null) {
			CartItem cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setCart(cart);
			cartItem.setQuantity(req.getQuantity());
			cartItem.setUserId(userId);
			
			int price = req.getQuantity()*product.getDiscountedPrice();
			cartItem.setPrice(price);
			cartItem.setSize(req.getSize());
			
			CartItem createdCartItem = cartItemService.createCartItem(cartItem);
			
			cart.getCartItems().add(createdCartItem);
		}
		
		return "Item Added to Cart...";
	}

	@Override
	public Cart findUserCart(Long userId) {

		Cart cart = cartRepo.findByUserId(userId);
		
		int totalPrice = 0;
		int totalDiscountedPrice = 0;
		int totalItem = 0;
		
		for(CartItem cartItem : cart.getCartItems()) {
			totalPrice=totalPrice+cartItem.getPrice();
			totalDiscountedPrice=totalDiscountedPrice+cartItem.getDiscountedPrice();
			totalItem=totalItem+cartItem.getQuantity();
		}
		
		cart.setTotalDiscountedPrice(totalDiscountedPrice);
		cart.setTotalItem(totalItem);
		cart.setTotalPrice(totalPrice);
		cart.setDiscount(totalPrice - totalDiscountedPrice);
		
		
		return cartRepo.save(cart);
	}

}
