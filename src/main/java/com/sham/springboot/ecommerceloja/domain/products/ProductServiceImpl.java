package com.sham.springboot.ecommerceloja.domain.products;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("produtoService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findBydId(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public Product create(Product product) {
		return productRepository.save(product);

	}

	@Override
	public void remove(Product product) {
		productRepository.delete(product);

	}

}
