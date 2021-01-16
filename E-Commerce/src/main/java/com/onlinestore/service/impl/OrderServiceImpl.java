package com.onlinestore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.domain.Order;
import com.onlinestore.domain.User;
import com.onlinestore.repository.OrderRepository;
import com.onlinestore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	public Order save(Order order) {
		return orderRepository.save(order);
	}
	
	public List<Order> findAll(){
		return (List<Order>) orderRepository.findAll();
	}
	public List<Order> findByUser(User user){
		return orderRepository.findByUser(user);
	}
	public Order findByOrder_id(int order_id) {
		return orderRepository.findByOrder_id(order_id);
	}
}
