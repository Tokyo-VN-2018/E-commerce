package com.onlinestore.service;

import java.util.List;

import com.onlinestore.domain.Order;
import com.onlinestore.domain.User;

public interface OrderService {
	Order save(Order order);
	List<Order> findAll();
	List<Order> findByUser(User user);
	Order findByOrder_id(int order_id);
}
