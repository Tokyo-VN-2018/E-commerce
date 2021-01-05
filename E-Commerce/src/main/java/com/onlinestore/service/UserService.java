package com.onlinestore.service;

import java.util.Set;

import com.onlinestore.domain.User;

public interface UserService {

	
	User findByUsername(String username);
	User findByEmail(String email);
	
	User createUser(User user) throws Exception;
	void updateInfo(User user, User userUpdate) throws Exception;
}
