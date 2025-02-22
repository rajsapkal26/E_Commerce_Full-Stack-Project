package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.org.model.Cart;
import com.org.model.CartItem;
import com.org.model.Product;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	
	
	
	@Query("select ci from CartItem ci where ci.cart=:cart and ci.product=:product and ci.size=:size and ci.userId=:userId")
	public CartItem isCartItemExist(@Param("cart") Cart cart,
									@Param("product") Product product,
									@Param("size") String size,
									@Param("userId") Long userId);
				
	

}
