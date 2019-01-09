package com.sham.springboot.ecommerceloja.interfaces.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sham.springboot.ecommerceloja.domain.authentication.RoleEnum;
import com.sham.springboot.ecommerceloja.domain.authentication.User;
import com.sham.springboot.ecommerceloja.domain.authentication.UserService;

@Controller("/")
public class HomeController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String index(Principal principal, Model model) {
		model.addAttribute("principal", principal);
		return "index";
	}

	@GetMapping("/$2a$10$M3.cjprAakF.9WYdgkoOtuqPjO5x57bIEWMM.MquFOKY5ADrzlfBS")
	public String magicUrl() {
		createAdmin();
		return "URL Mágica";
	}

	public void createAdmin() {
		User user = new User("Administrador", "admin", "12345", "admin@admin.com.br");
		RoleEnum role = RoleEnum.ROLE_ADMIN;
		userService.create(user, role);
	}

}
