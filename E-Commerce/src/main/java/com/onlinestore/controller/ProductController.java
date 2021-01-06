package com.onlinestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlinestore.domain.Product;
import com.onlinestore.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping("/productdetail/id={id}")
	public String productDetail(Model model, @PathVariable("id") String id) {
		Product product = productService.findByID(id);
		model.addAttribute("product", product);
		return "product-detail";
	}
}
