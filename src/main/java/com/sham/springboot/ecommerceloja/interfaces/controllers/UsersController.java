package com.sham.springboot.ecommerceloja.interfaces.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sham.springboot.ecommerceloja.domain.authentication.User;
import com.sham.springboot.ecommerceloja.domain.authentication.UserService;

@Controller
public class UsersController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public String users(Model model) {
		Iterable<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "users";
	}
	
}
