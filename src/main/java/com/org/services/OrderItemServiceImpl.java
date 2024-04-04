package com.org.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.model.OrderItem;
import com.org.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	
	@Autowired
	private OrderItemRepository orderItemRepo;
	
	
	@Override
	public OrderItem createOrderItem(OrderItem orderItem) {

		return orderItemRepo.save(orderItem);
	}

}
