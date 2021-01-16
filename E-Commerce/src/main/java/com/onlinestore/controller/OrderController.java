package com.onlinestore.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinestore.domain.Order;
import com.onlinestore.domain.User;
import com.onlinestore.service.OrderService;
import com.onlinestore.service.UserService;

@Controller
public class OrderController {
	@Autowired
	UserService userService;
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/orderhistory")
	public String orderHistory(Model model, Principal principal) {
		List<Order> orders = new ArrayList<>();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    	boolean hasAdminRole = authentication.getAuthorities().stream()
    	          .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
    	if(hasAdminRole) {
    		orders = orderService.findAll();
    	}
    	else {
    		User user = userService.findByUsername(principal.getName());
    		orders = orderService.findByUser(user);
    	}
    	model.addAttribute("orders", orders);
		return "orderHistory";
	}
	
	@RequestMapping("/changeStatus")
	public String changeStatus(@RequestParam("id") int id) {
		Order order = orderService.findByOrder_id(id);
		order.setStatus(true);
		orderService.save(order);
		return "redirect:/orderhistory";
	}
}
