package com.onlinestore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.onlinestore.domain.User;
import com.onlinestore.domain.security.Role;
import com.onlinestore.domain.security.UserRole;
import com.onlinestore.service.UserService;
import com.onlinestore.utility.SecurityUtility;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User();
		user1.setFullname("Nguyen Van A");
		user1.setUsername("vana");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("vana@gmail.com");
		user1.setEnabled(true);
		user1.setType(0);
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
		
	}

}
