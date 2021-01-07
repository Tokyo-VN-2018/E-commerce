package com.onlinestore.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinestore.domain.Category;
import com.onlinestore.domain.Product;
import com.onlinestore.domain.User;
import com.onlinestore.service.CategoryService;
import com.onlinestore.service.ProductService;
import com.onlinestore.service.UserService;

@Controller
public class SearchController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/searchByCategory")
	public String searchByCategory(
			@RequestParam("category") String category,
			Model model, Principal principal
			) {
		
		if (principal!=null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		
		String classActiveCategory = "active"+category;
		classActiveCategory = classActiveCategory.replaceAll("\\s+", "");
		classActiveCategory = classActiveCategory.replaceAll("&", "");
		model.addAttribute(classActiveCategory, true);
		
		/*Category cat = categoryService.findByCategoryID(category);
		
		List<Product> productList = productService.findByCategory(cat);*/
		List<Product> productList = productService.findByBigGroup(category);
		
		if (productList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "product";
		}
		
		model.addAttribute("productList", productList);
		
		return "product";
		
	}
	
	@RequestMapping("/searchProduct")
	public String searchProduct(
			@ModelAttribute("keyword") String keyword,
			Principal principal, Model model
			) {
		
		if (principal!=null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		
		List<Product> productList = productService.blurrySearch(keyword);
		
		if (productList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "product";
		}
		
		model.addAttribute("productList", productList);
		
		return "product";
		
	}
	
}
