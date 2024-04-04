package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
