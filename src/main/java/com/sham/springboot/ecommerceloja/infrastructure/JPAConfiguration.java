package com.sham.springboot.ecommerceloja.infrastructure;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JPAConfiguration {

	@Bean
	@Profile("dev")
	public DataSource dataSourceDevelopment() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/ecomerce_loja");
		dataSource.setUsername("sham");
		dataSource.setPassword("gsw");

		return dataSource;
	}
	
}
