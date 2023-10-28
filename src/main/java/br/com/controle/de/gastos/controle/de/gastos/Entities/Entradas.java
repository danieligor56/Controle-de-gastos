package br.com.controle.de.gastos.controle.de.gastos.Entities;

import java.io.Serializable;

import org.hibernate.annotations.ForeignKey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Column(name = "descript")
	private String descript;

	
	@NotNull
	@Column(name = "valor")
	private Float valor;

	@ManyToOne
	@JoinColumn(name = "cod_usuario",referencedColumnName = "id_usuario", nullable = false)
	private Usuario usuario;

}
