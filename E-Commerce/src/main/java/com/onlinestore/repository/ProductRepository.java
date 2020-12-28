package com.onlinestore.repository;

import org.springframework.data.repository.CrudRepository;

import com.onlinestore.domain.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {
	
}
