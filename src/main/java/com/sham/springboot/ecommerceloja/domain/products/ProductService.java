package com.sham.springboot.ecommerceloja.domain.products;

import java.util.Optional;

public interface ProductService {

	Iterable<Product> findAll();
	
	Optional<Product> findBydId(Long id);
	
	Product create(Product product);
	
	void remove(Product product);
	
}
