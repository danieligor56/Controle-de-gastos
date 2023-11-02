package br.com.controle.de.gastos.controle.de.gastos.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.controle.de.gastos.controle.de.gastos.DTO.EntradaDTO;
import br.com.controle.de.gastos.controle.de.gastos.Entities.Entradas;
import br.com.controle.de.gastos.controle.de.gastos.Services.EntradaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

@Tag(name = "Entradas")
@RestController
@RequestMapping("/api/v1/entradas")
public class EntradaController {
	
	@Autowired
	EntradaService entradaService;
	
	//Adicionar nova entrada.
	@Operation(summary = "Adicionar um entrada ", description = "Todos os valores que você recebe, por exemplo, sálario, vale refeição, vale-transporte.")
	@PostMapping("/new")
	public ResponseEntity<Entradas> criaNovaEntrada(@RequestBody EntradaDTO entradaDTO){
		Entradas novaEntrada = entradaService.adicionaNovaEntrada(entradaDTO);
		return ResponseEntity.ok().body(novaEntrada);
			
	}
	@Operation(summary = "Lista entradas",description = "Insere o código de um usuário e fornecer todas as entradas que o usuário possui")
	@Transactional
	@DeleteMapping("/del=/entradas/{id}")
	public ResponseEntity<Entradas> deleteEntPorId(@PathVariable long id){
		return ResponseEntity.ok(entradaService.deleteEntrada(id));
		
	}
	
	@GetMapping("/listAll/entradas")
	public ResponseEntity <List<Entradas>>listaPorUsuario(@RequestParam long id){
	return ResponseEntity.ok().body(entradaService.encontraPorUsuario(id));	
	}
	
	@PutMapping("/change=/entradas/")
	public ResponseEntity<Entradas> alteraEntrada(@RequestParam long id, @RequestBody EntradaDTO entradaDTO ) throws NotFoundException{
		entradaService.alteraEnt(id,entradaDTO);

		return ResponseEntity.noContent().build();
	}

}
