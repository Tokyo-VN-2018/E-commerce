package com.onlinestore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.domain.CartItem;
import com.onlinestore.domain.Order;
import com.onlinestore.domain.OrderItem;
import com.onlinestore.repository.CartItemRepository;
import com.onlinestore.repository.OrderItemRepository;
import com.onlinestore.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	public List<OrderItem> saveAll(List<OrderItem> orderitems){
		return (List<OrderItem>) orderItemRepository.saveAll(orderitems);
	}
	public List<OrderItem> saveFromCart(List<CartItem> cartitems, Order order){
		List<OrderItem> orderitems = new ArrayList<>();
		for (CartItem cartitem: cartitems) {
			OrderItem temp = new OrderItem();
			temp.setOrder(order);
			temp.setProduct(cartitem.getProduct());
			temp.setPrice(cartitem.getProduct().getPrice());
			temp.setQuantity(cartitem.getQuantity());
			orderitems.add(temp);
			cartItemRepository.deleteByID(cartitem.getCartitem_id());
		}
		return saveAll(orderitems);
	}
}
