package com.onlinestore.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.domain.Category;
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
	
	public Product findByID(String product_id) {
		return productRepository.findByProduct_id(product_id);
	}
	
	public List<Product> findByCategory(Category category){
		return (List<Product>) productRepository.findByCategory(category);
	}
	
	public List<Product> findByBigGroup(String bigGroup){
		return (List<Product>) productRepository.findByBigGroup(bigGroup);
	}
	public List<Product> randomProduct(int number){
		List<Product> products = this.findAll();
		products = getRandom(products, number);
		return products;
	};
	public List<Product> randomProduct(Category category, int number){
		List<Product> products = this.findByCategory(category);
		products = getRandom(products, number);
		return products;
	};
	public List<Product> randomProduct(String bigGroup, int number){
		List<Product> products = this.findByBigGroup(bigGroup);
		products = getRandom(products, number);
		return products;
	};
	
	private List<Product> getRandom(List<Product> product, int total){
		List<Product> newList = new ArrayList<>();
		Random rand = new Random();
		if(total > product.size()) {
			total = product.size();
		}
		for(int i=0;i<total;i++) {
			int index = rand.nextInt(product.size());
			newList.add(product.get(index));
			product.remove(index);
		}
		return newList;
	}
	
	public List<Product> blurrySearch(String keyword){
		return productRepository.findByproduct_nameContaining(keyword);
		
	}
	
}
