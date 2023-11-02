package br.com.controle.de.gastos.controle.de.gastos.Services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.controle.de.gastos.controle.de.gastos.DTO.EntradaDTO;
import br.com.controle.de.gastos.controle.de.gastos.Entities.Entradas;
import br.com.controle.de.gastos.controle.de.gastos.Repository.EntradaRepository;
import br.com.controle.de.gastos.controle.de.gastos.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.var;

@Service
public class EntradaService {

	@Autowired
	EntradaRepository entradaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ModelMapper modelMapper;

	public Entradas adicionaNovaEntrada(@PathVariable EntradaDTO entradaDTO) {

		Entradas novaEntrada = modelMapper.map(entradaDTO, Entradas.class);

		entradaRepository.save(novaEntrada);
		return null;
	}

	@Transactional
	public Entradas deleteEntrada(Long id) {
		entradaRepository.deleteById(id);
		return null;
	}

	public List<Entradas> encontraPorUsuario(long id) {	
		return entradaRepository.findByUsuarioId(id);
	}
	
	public Entradas alteraEnt(long id,EntradaDTO entradaDTO) throws NotFoundException {
		
		var encEntrada = entradaRepository.findById(id);
		
		if(encEntrada == null) {
			throw new NotFoundException();
		}
		
		Entradas modificaEntrada = modelMapper.map(entradaDTO, Entradas.class);
		modificaEntrada.setId(id);
		
		return entradaRepository.save(modificaEntrada);
	}

}
