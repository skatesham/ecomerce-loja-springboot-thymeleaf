package com.sham.springboot.ecommerceloja.domain.authentication;

public interface UserService {

	User create(User user, RoleEnum role);
	
	User findByUsername(String username);
	
	Iterable<User> findAll();
	
	User update(User user);
	
	void delete(User user);
}
