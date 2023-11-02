package br.com.controle.de.gastos.controle.de.gastos.Controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.controle.de.gastos.controle.de.gastos.DTO.DividaDTO;
import br.com.controle.de.gastos.controle.de.gastos.Entities.Dividas;
import br.com.controle.de.gastos.controle.de.gastos.Services.DividaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

@Tag(name = "Dividas")
@RestController
@RequestMapping("/api/v1/dividas")

public class DividaController {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	DividaService dividaService;
	
	@PostMapping
	@CrossOrigin(allowedHeaders = "http://localhost:8080/api/v1/dividas")
	public ResponseEntity<Dividas> criaNovaDivida(@RequestBody DividaDTO dividaDTO){
		Dividas novaDivida = dividaService.adicionaNovaDivida(dividaDTO);
		return ResponseEntity.ok().body(novaDivida);
			
	}
	@Transactional
	@DeleteMapping("/del=/{id}")
	public ResponseEntity<Dividas> deleteEntPorId(@PathVariable long id){
		return ResponseEntity.ok(dividaService.deleteDivida(id));
		
	}
	
	@GetMapping("/listAll/")
	public ResponseEntity <List<Dividas>>listaPorUsuario(@RequestParam long id){
	return ResponseEntity.ok().body(dividaService.encontraPorUsuario(id));	
	}
	
	@PutMapping("/change=/")
	public ResponseEntity<Dividas> alteraEntrada(@RequestParam long id, @RequestBody DividaDTO dividaDTO ) throws NotFoundException{
		dividaService.alteraDiv(id,dividaDTO);
		return ResponseEntity.noContent().build();
	}
}
