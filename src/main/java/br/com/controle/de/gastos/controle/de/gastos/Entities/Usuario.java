package br.com.controle.de.gastos.controle.de.gastos.Entities;


import java.io.Serializable;

import org.springframework.data.annotation.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idUser")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	//Vai ser email. 
	@Column(name = "login")
	private String login;
	
	@Column(name = "plvPass")
	private String plvPassString;
	
	
	

}
