package com.onlinestore.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.domain.CartItem;
import com.onlinestore.domain.User;
import com.onlinestore.service.CartItemService;
import com.onlinestore.service.UserCartService;
import com.onlinestore.service.UserService;

@Controller
@RequestMapping("/shoppingCart") 
public class ShoppingCartController {

	@Autowired
	private UserService userService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private UserCartService userCartService;

	@RequestMapping("/cart")
	public String shoppingCart(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());

		List<CartItem> cartItemList = cartItemService.findByUser(user);
		userCartService.updateUserCart(user);

		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("user", user);

		return "cart";
	}
}