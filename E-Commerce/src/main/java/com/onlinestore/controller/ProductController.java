package com.onlinestore.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlinestore.domain.Product;
import com.onlinestore.domain.User;
import com.onlinestore.service.ProductService;
import com.onlinestore.service.UserService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/productdetail/id={id}")
	public String productDetail(Model model, @PathVariable("id") String id) {
		Product product = productService.findByID(id);
		model.addAttribute("product", product);
		return "product-detail";
	}
	
	@RequestMapping("/product")
	public String product(
			Model model,
			Principal principal
			) {
		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		
		
		List<Product> productList = productService.findAll();
		model.addAttribute("productList", productList);
		model.addAttribute("activeAll", true);
		
		return "product";
	}
}
