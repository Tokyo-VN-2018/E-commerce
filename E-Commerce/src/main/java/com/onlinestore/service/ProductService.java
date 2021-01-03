package com.onlinestore.service;

import java.util.List;

import com.onlinestore.domain.Product;

public interface ProductService {

	Product save(Product product);
	
	List<Product> findAll();
}
