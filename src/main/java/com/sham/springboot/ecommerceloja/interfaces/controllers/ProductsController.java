package com.sham.springboot.ecommerceloja.interfaces.controllers;

import java.util.Arrays;

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
		
		if(!products.iterator().hasNext()) {
			this.createProducts();
			return findProducts(model);
		}
		
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

	public void createProducts() {
		Product[] products = new Product[5];

		products[0] = new Product("Livros Senhor dos Aneis", "Trilogia dos Senhor dos Aneis", 300.00);
		products[1] = new Product("Porche Carreira", "Lindo Carro", 1000000.0);
		products[2] = new Product("Caneta Bic Ponta Fina", "Precisão na escrita com ponta 0.7 mm", 1.99);
		products[3] = new Product("Site Web", "Site web com designes Bootstrap", 150.01);
		products[4] = new Product("Bicicleta", "Caloi 1000", 999.99);
		Arrays.asList(products).stream().forEach(p -> productService.create(p));
	}
}
