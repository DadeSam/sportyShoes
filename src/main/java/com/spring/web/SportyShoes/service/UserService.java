//UserService Class
package com.spring.web.SportyShoes.service;

import java.util.List;
import com.spring.web.SportyShoes.entity.User;

public interface UserService {
	
	List<User> getAllUsers();
	User findByUsername(String username);
	boolean validateUser(String username, String password);
	void updatePassword(String username, String newPassword);

}
