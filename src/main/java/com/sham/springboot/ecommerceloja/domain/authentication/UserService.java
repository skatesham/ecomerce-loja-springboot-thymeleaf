package com.sham.springboot.ecommerceloja.domain.authentication;

public interface UserService {

	public User create(User user, RoleEnum role);
	
	public User findByUsername(String username);
	
	public Iterable<User> findAll();
	
	public User update(User user);
	
	public void delete(User user);
}
