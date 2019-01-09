package com.sham.springboot.ecommerceloja.interfaces.controllers;

import java.security.Principal;
import java.util.Arrays;

import org.apache.commons.codec.language.bm.Rule.RPattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sham.springboot.ecommerceloja.domain.authentication.RoleEnum;
import com.sham.springboot.ecommerceloja.domain.authentication.User;
import com.sham.springboot.ecommerceloja.domain.authentication.UserService;
import com.sham.springboot.ecommerceloja.domain.products.Product;
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
		return "index";
	}

	@GetMapping("/magicurl:$2a$10$dIK6uH0ViCEJjkMW1VGSf.UfHf8qY1xRhBHEKcPjtzwMe04.1mAIq")
	@ResponseBody
	public String magicUrl() {

		User user = new User("Administrador", "admin", "12345", "admin@admin.com.br");
		RoleEnum role = RoleEnum.ROLE_ADMIN;

		Product[] products = new Product[5];

		products[0] = new Product("Livros Senhor dos Aneis", "Trilogia dos Senhor dos Aneis", 300.00);
		products[1] = new Product("Porche Carreira", "Lindo Carro", 1000000.0);
		products[2] = new Product("Caneta Bic Ponta Fina", "Precisão na escrita com ponta 0.7 mm", 1.99);
		products[3] = new Product("Site Web", "Site web com designes Bootstrap", 150.01);
		products[4] = new Product("Bicicleta", "Caloi 1000", 999.99);

		try {
			userService.create(user, role);
			Arrays.asList(products).stream().forEach(p -> productService.create(p));
		} catch (Exception e) {

		}
		return "Url Mágica acessada com Sucesso";

	}

}
