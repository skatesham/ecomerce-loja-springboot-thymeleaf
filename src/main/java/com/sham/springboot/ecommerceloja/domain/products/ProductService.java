package com.sham.springboot.ecommerceloja.domain.products;

import java.util.Optional;

public interface ProductService {

	public Iterable<Product> findAll();
	
	public Optional<Product> findBydId(Long id);
	
	public Product create(Product product);
	
	public void remove(Product product);
	
}
