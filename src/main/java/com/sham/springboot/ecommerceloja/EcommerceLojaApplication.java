package com.sham.springboot.ecommerceloja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class EcommerceLojaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceLojaApplication.class, args);
	}

}

