package com.sham.springboot.ecommerceloja.interfaces.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void findProductsTest() throws Exception {
		
		this.mockMvc.perform(get("/products")).andExpect(model().attributeExists("products")).andExpect(status().isOk());
	}
	
}
