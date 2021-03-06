package com.sham.springboot.ecommerceloja.interfaces.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sham.springboot.ecommerceloja.domain.authentication.RoleEnum;
import com.sham.springboot.ecommerceloja.domain.authentication.User;
import com.sham.springboot.ecommerceloja.domain.authentication.UserService;
import com.sham.springboot.ecommerceloja.interfaces.dto.LoginDTO;

@Controller
public class AuthenticationController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "signin", method = RequestMethod.GET)
	public String signIn(User user) {
		return "signin";
	}

	@RequestMapping(value = "signin", method = RequestMethod.POST)
	public String signInPost(@Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "signin";
		}
		user = userService.create(user, RoleEnum.ROLE_USER);
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(LoginDTO loginDTO, @RequestParam(value="error", required=false) String error, Model model) {
		model.addAttribute("error", error);
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}

}
