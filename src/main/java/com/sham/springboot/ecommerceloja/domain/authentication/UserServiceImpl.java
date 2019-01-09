package com.sham.springboot.ecommerceloja.domain.authentication;

import java.util.Arrays;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	@CacheEvict(value="users", allEntries=true)
	public User create(User user, RoleEnum roleEnum) {
		Optional<Role> role = roleRepository.findById(roleEnum.name());
		if(role.isPresent()) {
			user.setRoles(Arrays.asList(role.get()));
		}
		else {
			Role newRole = roleRepository.save(new Role(roleEnum));
			user.setRoles(Arrays.asList(newRole));
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Transactional
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username).get();
	}
	
	@Transactional
	@Override
	@Cacheable("users")
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Transactional
	@Override
	@CacheEvict(value="users", allEntries=true)
	public User update(User user) {
		return userRepository.save(user);
	}

	@Transactional
	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.findByUsername(username);
	}

}
