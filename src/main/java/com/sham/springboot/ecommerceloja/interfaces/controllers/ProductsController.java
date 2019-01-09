package com.sham.springboot.ecommerceloja.interfaces.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sham.springboot.ecommerceloja.domain.products.Product;
import com.sham.springboot.ecommerceloja.domain.products.ProductService;

@Controller()
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	ProductService productService;

	@GetMapping()
	public String findProducts(Model model) {

		Iterable<Product> products = productService.findAll();
		model.addAttribute("products", products);

		return "products";
	}

	@GetMapping("add")
	public String add(Product produto) {
		return "addProduct";
	}

	@PostMapping("add")
	public String save(@Valid Product product, BindingResult bindingResult) {

		System.out.println(product);
		if (bindingResult.hasErrors()) {
			return "addProduct";
		}
		productService.create(product);
		return "redirect:/products";
	}
}
