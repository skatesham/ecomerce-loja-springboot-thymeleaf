package com.sham.springboot.ecommerceloja.infrastructure;

import java.net.URI;
import java.net.URISyntaxException;

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

	@Bean
	@Profile("test")
	public DataSource dataSourceTest() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/ecomerce_loja_test");
		dataSource.setUsername("sham");
		dataSource.setPassword("gsw");

		return dataSource;
	}
	
    @Bean
    @Profile("prod")
    public DataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

        DriverManagerDataSource basicDataSource = new DriverManagerDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

}
