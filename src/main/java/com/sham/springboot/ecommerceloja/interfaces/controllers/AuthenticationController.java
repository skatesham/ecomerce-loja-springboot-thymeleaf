package com.sham.springboot.ecommerceloja.interfaces.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sham.springboot.ecommerceloja.domain.authentication.RoleEnum;
import com.sham.springboot.ecommerceloja.domain.authentication.User;
import com.sham.springboot.ecommerceloja.domain.authentication.UserService;

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
		try {
			user = userService.create(user, RoleEnum.ROLE_USER);
		} catch (Exception e) {
			e.printStackTrace();
			return "signin";
		}
		return "redirect:/login";
	}
}
