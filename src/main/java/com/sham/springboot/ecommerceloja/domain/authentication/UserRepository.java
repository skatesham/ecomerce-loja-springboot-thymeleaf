package com.sham.springboot.ecommerceloja.domain.authentication;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);
	
	Optional<User> findByEmail(String email);
	
	
}
