package br.com.controle.de.gastos.controle.de.gastos.Entities;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Entradas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Entradas implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@PrimaryKeyJoinColumn
	private Usuario idUser;
		
	@Column(name = "descript")
	private String descript;
	
	@Column(name = "valor")
	private Float valor;
	
	

}
