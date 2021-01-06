package com.onlinestore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.domain.Product;
import com.onlinestore.repository.ProductRepository;
import com.onlinestore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> findAll(){
		return (List<Product>) productRepository.findAll();
	}
	
	public Object findById(int product_id) {
		return productRepository.findById((long) product_id);
	}
	
}
