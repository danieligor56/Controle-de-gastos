package br.com.controle.de.gastos.controle.de.gastos.DTO;

import br.com.controle.de.gastos.controle.de.gastos.Entities.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EntradaDTO {
	
	@NotNull
	
	private String descript;
	
	
	@NotNull
	private Float valor;
	
	@ManyToOne
	@JoinColumn(name = "cod_usuario",referencedColumnName = "id_usuario", nullable = false)
	private Usuario usuario;

}
