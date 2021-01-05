package com.onlinestore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.onlinestore.domain.CartItem;
import com.onlinestore.domain.User;

public interface CartItemRepository extends CrudRepository<CartItem, Long>{
	List<CartItem> findByUser(User user);

}