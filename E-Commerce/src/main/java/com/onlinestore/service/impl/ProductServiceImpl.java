package com.onlinestore.service.impl;

import java.util.List;

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
	
}
