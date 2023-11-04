package br.com.controle.de.gastos.controle.de.gastos.Entities;

import lombok.Getter;

public enum UsuarioRole {
	ADMIN("admin"),
	USER("user");
	
	@Getter
	private	String role;
	
	private UsuarioRole(String role) {
		this.role = role; 
	}
	
}
