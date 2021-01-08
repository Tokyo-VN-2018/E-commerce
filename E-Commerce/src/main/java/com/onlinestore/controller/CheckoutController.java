package com.onlinestore.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlinestore.domain.CartItem;
import com.onlinestore.domain.Order;
import com.onlinestore.domain.Product;
import com.onlinestore.domain.User;
import com.onlinestore.service.CartItemService;
import com.onlinestore.service.OrderItemService;
import com.onlinestore.service.OrderService;
import com.onlinestore.service.ProductService;
import com.onlinestore.service.UserCartService;
import com.onlinestore.service.UserService;

@Controller
public class CheckoutController {
	@Autowired
	private UserService userService;

	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ProductService productService;

	@Autowired
	private UserCartService userCartService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@RequestMapping("/checkout")
	public String checkout(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		List<CartItem> cartItemList = cartItemService.findByUser(user);
		userCartService.updateUserCart(user);
		model.addAttribute("cartItems", cartItemList);
		model.addAttribute("user", user);
		return "checkout";
	}
	
	@RequestMapping("/process")
	public String process(@ModelAttribute("order") Order order, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		List<CartItem> cartItemList = cartItemService.findByUser(user);
		order.setStatus(false);
		order.setUser(user);
		order = orderService.save(order);
		orderItemService.saveFromCart(cartItemList, order);
		return "redirect:/thankyou";
	}
	
	@RequestMapping("/thankyou")
	public String thankyou() {
		return "thankyou";
	}
}
