package com.sham.springboot.ecommerceloja.domain.products;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=3, max=100)
	private String name;
	
	@NotNull
	@Size(min=3, max=100)
	private String description;
	
	@NotNull
	private Price price = new Price();
	
	private String imagePath;
	
	public Product(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price.setValue(price);
	}
	
}
