package com.onlinestore.repository;

import org.springframework.data.repository.CrudRepository;

import com.onlinestore.domain.Order;

public interface OrderRepository extends CrudRepository<Order,Long> {
}