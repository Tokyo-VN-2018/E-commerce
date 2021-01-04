package com.onlinestore.service;

import java.util.List;

import com.onlinestore.domain.CartItem;
import com.onlinestore.domain.User;

public interface CartItemService {
	List<CartItem> findByUser(User user);
	CartItem updateCartItem(CartItem cartItem);
}
