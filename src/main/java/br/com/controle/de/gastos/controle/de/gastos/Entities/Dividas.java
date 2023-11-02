package br.com.controle.de.gastos.controle.de.gastos.Entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Dividas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Dividas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID",nullable = false,unique = true)
	private long id;

	@NotNull
	@Column(name = "descript")
	private String descript;

	@NotNull
	@Column(name = "valor")
	private Float valor;

	@NotNull
	@Column(name = "qtdParc")
	private Integer quantidadeParcelas;

	@JsonIgnore
	@Getter@Setter
	@ManyToOne
	@JoinColumn(name = "cod_usuario",referencedColumnName = "id_usuario", nullable = false)
	private Usuario usuario;

}
