package br.com.controle.de.gastos.controle.de.gastos.DTO;

import jakarta.persistence.Column;

public class UsuarioDTO {

	@Column(name = "nome")
	private String nome;
	
	//Vai ser email. 
	@Column(name = "login")
	private String login;
	
	@Column(name = "plvPass")
	private String plvPassString;
}
