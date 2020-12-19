package com.onlinestore.service;

import com.onlinestore.domain.User;
import com.onlinestore.domain.security.PasswordResetToken;

public interface UserService {

	PasswordResetToken getPasswordResetToken(final String token);
	void createPasswordResetTokenForUser(final User user, final String token);
}
