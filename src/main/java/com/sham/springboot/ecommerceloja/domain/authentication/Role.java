package com.sham.springboot.ecommerceloja.domain.authentication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "role")
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = -7198514176046036731L;

	@Id
	@Column(unique = true, nullable = false)
	private String name;
	
	public Role(RoleEnum role) {
		this.name = role.name();
	}
	
	@Override
	public String getAuthority() {
		return this.name;
	}

	
	
}
