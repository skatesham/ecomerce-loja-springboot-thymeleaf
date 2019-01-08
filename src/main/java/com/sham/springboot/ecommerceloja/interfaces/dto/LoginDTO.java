package com.sham.springboot.ecommerceloja.interfaces.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LoginDTO {
	
	@NotNull
	@Size(min = 4, max = 15)
	String username;
	
	@NotNull
	@Size(min = 3)
	String password;
}
