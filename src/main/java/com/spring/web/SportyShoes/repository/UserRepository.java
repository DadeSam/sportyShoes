//UserRepository Class
package com.spring.web.SportyShoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.web.SportyShoes.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	User findByUsername(String username);
}
