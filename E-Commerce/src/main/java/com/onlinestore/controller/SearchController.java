package com.onlinestore.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
			Model model, Principal principal,
			@RequestParam(name = "page", defaultValue = "0") int page
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
		/* List<Product> productList = productService.findByBigGroup(category); */
		
		Pageable pageRequest = PageRequest.of(page, 12);
		
		Page<Product> productList = productService.findByBigGroupPaginated(category, pageRequest);
		int totalPage = productList.getTotalPages();
		List<Integer> pages = new ArrayList<Integer>();
		if (totalPage==0) {
			pages.add(0);
		}else {
		for (int i = 0; i <totalPage ; i++) {
			pages.add(i);
			}
		}
		
		if (productList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "product";
		}
		
		model.addAttribute("productList", productList);
		model.addAttribute("pages", pages);
		
		return "product";
		
	}
	
	@RequestMapping("/searchProduct")
	public String searchProduct(
			@ModelAttribute("keyword") String keyword,
			Principal principal, Model model,
			@RequestParam(name = "page", defaultValue = "0") int page
			) {
		
		if (principal!=null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		
		Pageable pageRequest = PageRequest.of(page, 12);
		
		Page<Product> productList = productService.blurrySearchPaginated(keyword, pageRequest);
		int totalPage = productList.getTotalPages();
		List<Integer> pages = new ArrayList<Integer>();
		if (totalPage==0) {
			pages.add(0);
		}else {
		for (int i = 0; i <totalPage ; i++) {
			pages.add(i);
			}
		}
		
		if (productList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "product";
		}
		
		model.addAttribute("productList", productList);
		model.addAttribute("pages", pages);
		
		return "product";
		
	}
	
}
