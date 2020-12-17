package com.onlinestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/myAccount")
	public String myAccount() {
		return "account";
	}/*
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("aa-myaccount-login",true);
		return "account";
	}*/
}
