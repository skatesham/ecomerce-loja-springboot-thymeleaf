package com.sham.springboot.ecommerceloja.domain.products;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("produtoService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Cacheable("books")
	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findBydId(Long id) {
		return productRepository.findById(id);
	}

	@Transactional
	@Override
	@CacheEvict(value="books", allEntries=true)
	public Product create(Product product) {
		return productRepository.save(product);

	}

	@Transactional
	@Override
	public void remove(Product product) {
		productRepository.delete(product);

	}

}
