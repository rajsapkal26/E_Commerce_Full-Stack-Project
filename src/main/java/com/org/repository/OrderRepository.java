package com.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.org.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	
	
	 @Query("select o from Order o where o.user.id=:userId and (o.orderStatus='placed' or o.orderStatus='confirmed' or o.orderStatus='shipped' or o.orderStatus='delivered')")
	 public List<Order> getUsersOrders(@Param ("userId") Long userId);
	
	
	
	
}
