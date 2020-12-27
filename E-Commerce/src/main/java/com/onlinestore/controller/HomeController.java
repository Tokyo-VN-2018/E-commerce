package com.onlinestore.controller;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinestore.domain.User;
import com.onlinestore.domain.security.PasswordResetToken;
import com.onlinestore.domain.security.Role;
import com.onlinestore.domain.security.UserRole;
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
	private UserSecurityService userSecurityService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/myAccount")
	public String myAccount() {
		return "account";
	}
	@RequestMapping("/login")
	public String login(Model model) {
		return "account";
	}
	@RequestMapping("/myprofile")
	public String myprofile(Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute(user);
		
		return "myProfile";
	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String newUserPost(HttpServletRequest request,
			@ModelAttribute("email") String userEmail,
			@ModelAttribute("username") String username,
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
		
		
		String password =  SecurityUtility.randomPassword();
		String encryptedpassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedpassword);
		
		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_USER");
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, role));
		userService.createUser(user, userRoles);
		
		String token = UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user, token);
		
		String appUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		SimpleMailMessage email = mailConstructor.constructResetTokenEmail(appUrl, request.getLocale(), token, user, password);
		mailSender.send(email);
		
		model.addAttribute("emailSent","true");
		
		return "account";
		
	}
	
	@RequestMapping("/newUser")
	public String newUser(Locale locale,
			@RequestParam("token") String token,
			Model model)	 {
		
		PasswordResetToken passToken = userService.getPasswordResetToken(token);
		
		if(passToken == null) {
			String message = "Invalid Token.";
			model.addAttribute("message", message);
			return "redirect:/badRequest";
		}
		
		User user = passToken.getUser();
		String username = user.getUsername();
		
		UserDetails userDetails = userSecurityService.loadUserByUsername(username);
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		model.addAttribute("user",user);
		
		return "myProfile";
	}
	
	@RequestMapping("/forgetPassword")
	public String forgetPassword(HttpServletRequest request,
			@ModelAttribute("email") String email,
			Model model) {
		
		User user = userService.findByEmail(email);
		
		if (user == null) {
			model.addAttribute("emailNotExist", true);
			
			return "account";
		}
		
		String password =  SecurityUtility.randomPassword();
		String encryptedpassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedpassword);
		
		userService.save(user);
		
		String token = UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user, token);
		
		String appUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		SimpleMailMessage newEmail = mailConstructor.constructResetTokenEmail(appUrl, request.getLocale(), token, user, password);
		mailSender.send(newEmail);
		
		model.addAttribute("forgetPasswordEmailSent","true");
		
		return "account";
	}
	
}
