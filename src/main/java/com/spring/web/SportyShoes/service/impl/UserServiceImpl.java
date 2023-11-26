//UserServiceImpl Class
package com.spring.web.SportyShoes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.SportyShoes.entity.User;
import com.spring.web.SportyShoes.repository.UserRepository;
import com.spring.web.SportyShoes.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl (UserRepository userRepository) { 
		super();
		this.userRepository = userRepository; 
	 }

	@Override
	public User findByUsername(String username) { 
	return userRepository.findByUsername(username); }
		 
	@Override
	public List<User> getAllUsers() {
        return userRepository.findAll();
    }
	
	public boolean validateUser(String username, String password) {
	    User user = userRepository.findByUsername(username);
	    if (user != null) {
	        if (user.getPassword().equals(password)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public void updatePassword(String username, String newPassword) {
	    User user = userRepository.findByUsername(username);
	    user.setPassword(newPassword);
	    userRepository.save(user);
	}
}