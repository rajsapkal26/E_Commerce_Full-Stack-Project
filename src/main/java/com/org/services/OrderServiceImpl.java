package com.org.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.org.exceptions.OrderException;
import com.org.model.Address;
import com.org.model.Cart;
import com.org.model.CartItem;
import com.org.model.Order;
import com.org.model.OrderItem;
import com.org.model.User;
import com.org.repository.AddressRepository;
import com.org.repository.CartRepository;
import com.org.repository.OrderItemRepository;
import com.org.repository.OrderRepository;
import com.org.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	private OrderRepository orderRepo;
	private CartService cartService;
	private AddressRepository addressRepo;
	private UserRepository userRepo;
	private OrderItemService orderItemService;
	private OrderItemRepository orderItemRepo;
	


	public OrderServiceImpl(OrderRepository orderRepo, CartService cartService, AddressRepository addressRepo,
			UserRepository userRepo, OrderItemService orderItemService, OrderItemRepository orderItemRepo) {
	
		this.orderRepo = orderRepo;
		this.cartService = cartService;
		this.addressRepo = addressRepo;
		this.userRepo = userRepo;
		this.orderItemService = orderItemService;
		this.orderItemRepo = orderItemRepo;
	}
	

	@Override
	public Order createOrder(User user, Address shippingAddress) {

		shippingAddress.setUser(user);
		Address address  = addressRepo.save(shippingAddress);
		user.getAddress().add(address);
		
		Cart cart  = cartService.findUserCart(user.getId());
		List<OrderItem> orderItems= new ArrayList<>();
		
		for(CartItem item: cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			
			orderItem.setPrice(item.getPrice());
			orderItem.setProduct(item.getProduct());
			orderItem.setQuantity(item.getQuantity());
			orderItem.setSize(item.getSize());
			orderItem.setUserId(item.getUserId());
			orderItem.setDiscountedPrice(item.getDiscountedPrice());
			
			OrderItem createdOrderitem = orderItemRepo.save(orderItem);
			
			orderItems.add(createdOrderitem);
			
		}
		
			Order createdOrder = new Order();
			createdOrder.setUser(user);
			createdOrder.setOrderItems(orderItems);
			createdOrder.setTotalPrice(cart.getTotalPrice());
			createdOrder.setTotalDiscountedPrice(cart.getTotalDiscountedPrice());
			createdOrder.setDiscount(cart.getDiscount());
			createdOrder.setTotalItem(cart.getTotalItem());
			
			createdOrder.setShippingAddress(address);
			createdOrder.setOrderDate(LocalDateTime.now());
			createdOrder.setOrderStatus("PENDING");
			createdOrder.getPaymentDetails().setStatus("PENDING");
			createdOrder.setCreatedAt(LocalDateTime.now());
			
			Order savedOrder = orderRepo.save(createdOrder);
			
			for(OrderItem item:orderItems) {
				item.setOrder(savedOrder);
				orderItemRepo.save(item);
			}
		
		return savedOrder;
	}
	
	

	@Override
	public Order findOrderById(Long orderId) throws OrderException {

		Optional<Order> opt = orderRepo.findById(orderId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		
		throw new OrderException("order not exist with id" + orderId);

	}

	@Override
	public List<Order> usersOrderHistory(Long orderId) {

		List<Order> orders = orderRepo.getUsersOrders(orderId);
		
		return orders;
	}

	@Override
	public Order placedOrder(Long orderId) throws OrderException {

		Order order= findOrderById(orderId);
		order.setOrderStatus("PLACED");
		order.getPaymentDetails().setStatus("COMPLETED");
		
		return order;
	}

	@Override
	public Order confirmedOrder(Long orderId) throws OrderException {
		
		Order order= findOrderById(orderId);
		order.setOrderStatus("CONFIRMED");
	
		return orderRepo.save(order);
	}

	@Override
	public Order shippedOrder(Long orderId) throws OrderException {
		
		Order order= findOrderById(orderId);
		order.setOrderStatus("SHIPPED");
		
		return orderRepo.save(order);
	}

	@Override
	public Order deliveredOrder(Long orderId) throws OrderException {

		Order order= findOrderById(orderId);
		order.setOrderStatus("DELIVERED");
		
		return orderRepo.save(order);
	}

	@Override
	public Order canceledOrder(Long orderId) throws OrderException {
		Order order= findOrderById(orderId);
		order.setOrderStatus("CANCELED");
		
		return orderRepo.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public void deleteOrder(Long orderId) throws OrderException {
		
		Order order= findOrderById(orderId);
		
		
			orderRepo.deleteById(orderId);;
		
	}
	
	

}
