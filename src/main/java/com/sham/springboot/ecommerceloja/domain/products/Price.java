package com.sham.springboot.ecommerceloja.domain.products;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Price {
	
	@NotNull
	private double value;
	
	@Override
	public String toString() {
		return String.format("%.2f", value);
	}
	
	
}
