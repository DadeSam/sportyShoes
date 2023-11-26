//User entity Class
package com.spring.web.SportyShoes.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

@Entity
@Table (name="user")
public class User {
	@Id
	String username;
	String password;
	String email_address;
	String location;
}
