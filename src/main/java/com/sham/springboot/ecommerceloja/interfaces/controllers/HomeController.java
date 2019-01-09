package com.sham.springboot.ecommerceloja.interfaces.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sham.springboot.ecommerceloja.domain.authentication.RoleEnum;
import com.sham.springboot.ecommerceloja.domain.authentication.User;
import com.sham.springboot.ecommerceloja.domain.authentication.UserService;
import com.sham.springboot.ecommerceloja.domain.products.ProductService;

@Controller("/")
public class HomeController {

	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String index(Principal principal, Model model) {
		model.addAttribute("principal", principal);
		if(!userService.findAll().iterator().hasNext()) {
			this.createAdmin();
		}
		return "index";
	}

	public void createAdmin() {
		User user = new User("Administrador", "admin", "12345", "admin@admin.com.br");
		RoleEnum role = RoleEnum.ROLE_ADMIN;
		userService.create(user, role);
	}

}
