package br.com.controle.de.gastos.controle.de.gastos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.controle.de.gastos.controle.de.gastos.DTO.EntradaDTO;
import br.com.controle.de.gastos.controle.de.gastos.Entities.Entradas;
import br.com.controle.de.gastos.controle.de.gastos.Services.EntradaService;
import lombok.experimental.var;

@RestController
@RequestMapping("/api/v1/entradas")
public class EntradaController {
	
	@Autowired
	EntradaService entradaService;
	
	//Adicionar nova entrada.
	
	@PostMapping
	public ResponseEntity<Entradas> criaNovaEntrada(@RequestBody EntradaDTO entradaDTO){
		Entradas novaEntrada = entradaService.adicionaNovaEntrada(entradaDTO);
		return ResponseEntity.ok().body(novaEntrada);
			
	}

}
