package com.onlinestore.service;

import java.util.List;

import com.onlinestore.domain.Category;
import com.onlinestore.domain.Product;

public interface ProductService {

	Product save(Product product);
	
	List<Product> findAll();
	Product findByID(String product_id);
	List<Product> findByCategory(Category category);
	List<Product> findByBigGroup(String bigGroup);
	List<Product> randomProduct(int number);
	List<Product> randomProduct(Category category, int number);
	List<Product> randomProduct(String bigGroup, int number);
}
