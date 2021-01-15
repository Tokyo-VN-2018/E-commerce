package com.onlinestore.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public String productDetail(Model model, @PathVariable("id") int id) {
		Product product = productService.findByID(id);
		model.addAttribute("productdetail", product);
		List<Product> products = productService.randomProduct(product.getCategory(), 4);
		model.addAttribute("products",products);
		return "product-detail";
	}
	
	/* @RequestMapping(value = "/product", method = RequestMethod.POST) */
	@RequestMapping("/product") 
	public String product(
			Model model,
			Principal principal,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@ModelAttribute("sorttype") String sorttype
			) {
		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		
		String optionActiveSort;
		Pageable pageRequest;
		if (sorttype.equalsIgnoreCase("3")) {
			pageRequest = PageRequest.of(page, 12, Sort.by("price").descending());
			optionActiveSort = "t3";
		}else if (sorttype.equalsIgnoreCase("2")) {
			pageRequest = PageRequest.of(page, 12, Sort.by("price").ascending());
			optionActiveSort = "t2";
		}else if (sorttype.equalsIgnoreCase("4")) {
			pageRequest = PageRequest.of(page, 12, Sort.by("product_name").ascending());
			optionActiveSort = "t4";
		}else if (sorttype.equalsIgnoreCase("5")) {
			pageRequest = PageRequest.of(page, 12, Sort.by("product_name").descending());
			optionActiveSort = "t5";
		}else {
			pageRequest = PageRequest.of(page, 12);
			optionActiveSort = "t1";
		}
		model.addAttribute(optionActiveSort, true);
		
		Page<Product> productList = productService.findPaginated(pageRequest);
		int totalPage = productList.getTotalPages();
		List<Integer> pages = new ArrayList<Integer>();
		if (totalPage==0) {
			pages.add(0);
		}else {
		for (int i = 0; i <totalPage ; i++) {
			pages.add(i);
			}
		}
		
		/* List<Product> productList = productService.findPaginated(pageable); */
		model.addAttribute("productList", productList);
		model.addAttribute("activeAll", true);
		model.addAttribute("pages", pages);
		
		return "product";
	}
	
	
}
