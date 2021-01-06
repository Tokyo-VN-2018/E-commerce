package com.onlinestore.service;

import java.util.List;
import java.util.Optional;

import com.onlinestore.domain.Product;

public interface ProductService {

	Product save(Product product);
	
	Object findById(int i);
	
	List<Product> findAll();
}
