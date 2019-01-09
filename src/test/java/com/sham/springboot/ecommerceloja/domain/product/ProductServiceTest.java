package com.sham.springboot.ecommerceloja.domain.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.sham.springboot.ecommerceloja.domain.products.Product;
import com.sham.springboot.ecommerceloja.domain.products.ProductService;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class ProductServiceTest {

	@Autowired
	ProductService productService;
	
	@Transactional
	@Test
	public void createTest() {
		
		Product expected = new Product("produto", "descricao", 1.0);
		Product actual = productService.create(expected);
		assertNotNull(actual);
		assertNotNull(actual.getId());
		assertEquals(expected.getPrice(), actual.getPrice());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDescription(), actual.getDescription());
		
	}
	
	
}
