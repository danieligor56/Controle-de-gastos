package br.com.controle.de.gastos.controle.de.gastos.Entities;

import java.io.Serializable;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDivida")
	private long idDivida;

	@NotNull
	@Column(name = "descript")
	private String descript;

	@NotNull
	@Column(name = "valor")
	private Float valor;

	@NotNull
	@Column(name = "qtdParc")
	private Integer quantidadeParcelas;

	@ManyToOne
	@JoinColumn(name = "fk_usuario", nullable = false)
	private Usuario usuario;

}
