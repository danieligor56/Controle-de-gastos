package br.com.controle.de.gastos.controle.de.gastos.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.controle.de.gastos.controle.de.gastos.DTO.EntradaDTO;
import br.com.controle.de.gastos.controle.de.gastos.Entities.Entradas;
import br.com.controle.de.gastos.controle.de.gastos.Repository.EntradaRepository;

@Service
public class EntradaService {

	@Autowired
	EntradaRepository entradaRepository;
	@Autowired
	ModelMapper modelMapper;
	
	public Entradas adicionaNovaEntrada (@PathVariable EntradaDTO entradaDTO) {
		
	Entradas novaEntrada = modelMapper.map(entradaDTO, Entradas.class);
			
	entradaRepository.save(novaEntrada);
		return null;
	}

}
