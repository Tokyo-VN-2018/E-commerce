package com.onlinestore.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinestore.domain.Product;
import com.onlinestore.domain.User;
import com.onlinestore.domain.security.PasswordResetToken;
import com.onlinestore.service.ProductService;
import com.onlinestore.service.UserService;
import com.onlinestore.service.impl.UserSecurityService;
import com.onlinestore.utility.MailConstructor;
import com.onlinestore.utility.SecurityUtility;

@Controller
public class HomeController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private	ProductService productService;
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	@RequestMapping({"/","/index","/home"})
	public String index(Model model) {
		return "index";
	}
	@RequestMapping("/login")
	public String login(Model model) {
		if(SecurityContextHolder.getContext().getAuthentication().getName()!="anonymousUser") {
			return "redirect:/myprofile";
		}
		return "account";
	}
	
    @RequestMapping("/success")
    public String loginPageRedirect(HttpServletRequest request, Principal principal) throws IOException, ServletException {

    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    	boolean hasUserRole = authentication.getAuthorities().stream()
    	          .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        if(hasUserRole){
        	return "redirect:/adminPortal";                            
         }
         else {
             return "redirect:/";
         }
    }
    
    @RequestMapping("/adminPortal")
    public String adminPortal() {
    	return "adminPortal";
    }
    
    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public String addProduct(Model model) {
    	Product product = new Product();
    	model.addAttribute("product",product);
    	return "addProduct";
    }
	
    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String addProductPost(
    		@ModelAttribute("product") Product product, HttpServletRequest request
    		) {
    	productService.save(product);
    	
    	return "redirect:productList";
    }
    
    @RequestMapping("/productList")
    public String productList(Model model) {
		List<Product> productList = productService.findAll();
		model.addAttribute("productList", productList);
    	
    	return "productList";
    }
    
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String newUserPost(HttpServletRequest request,
			@ModelAttribute("email") String userEmail,
			@ModelAttribute("username") String username,
			@ModelAttribute("password") String password,
			Model model) throws Exception {
		model.addAttribute("email", userEmail);
		model.addAttribute("username", username);
		
		if (userService.findByUsername(username) != null) {
			model.addAttribute("usernameExists", true);
			return "account";
		}
		
		if (userService.findByEmail(userEmail) != null) {
			model.addAttribute("emailExists", true);
			return "account";
		}
		
		User user = new User();
		user.setUsername(username);
		user.setEmail(userEmail);
		String encryptedpassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedpassword);
		
		userService.createUser(user);
		UserDetails userDetails = userSecurityService.loadUserByUsername(username);
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "redirect:/myprofile";
	}

	@RequestMapping("/myprofile")
	public String myprofile(Model model, Principal principal) {
		User user = new User();
        String username = principal.getName();
        user = userService.findByUsername(username);
        model.addAttribute(user);
		return "myProfile";
	}
	
	@RequestMapping("/product")
	public String product(Model model) {
		List<Product> productList = productService.findAll();
		model.addAttribute("productList", productList);
		
		return "product";
	}
	
}
