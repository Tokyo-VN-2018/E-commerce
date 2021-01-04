package com.onlinestore.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.domain.CartItem;
import com.onlinestore.domain.User;
import com.onlinestore.repository.CartItemRepository;
import com.onlinestore.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	public List<CartItem> findByUser(User user){
		return cartItemRepository.findByUser(user);
	}
	
	@SuppressWarnings("deprecation")
	public CartItem updateCartItem(CartItem cartItem) {
		BigDecimal bigDecimal= new BigDecimal(cartItem.getProduct().getPrice()).multiply(new BigDecimal(cartItem.getQuantity()));
		
		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		cartItem.setSubtotal(bigDecimal);
		
		cartItemRepository.save(cartItem);
		
		return cartItem;
	}

}
