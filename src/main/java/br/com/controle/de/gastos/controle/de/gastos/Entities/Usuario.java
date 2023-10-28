package br.com.controle.de.gastos.controle.de.gastos.Entities;

import java.io.Serializable;
import org.hibernate.validator.constraints.UniqueElements;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn
	private long id;
	
	@NotNull
	@Column(name = "nome")
	private String nome;
	
	@NotNull
	//Vai ser email. 
	@Column(name = "login")
	private String login;
	
	@NotNull
	@Column(name = "plvPass")
	private String plvPassString;
	
	

	
	
	

}
