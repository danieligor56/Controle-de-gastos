package br.com.controle.de.gastos.controle.de.gastos.Services;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import br.com.controle.de.gastos.controle.de.gastos.DTO.DividaDTO;
import br.com.controle.de.gastos.controle.de.gastos.Entities.Dividas;
import br.com.controle.de.gastos.controle.de.gastos.Repository.DividasRepository;

@Service
public class DividaService {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	DividasRepository dividasRepository;
	
	@CrossOrigin(allowedHeaders = "http://localhost:8080")
	public Dividas adicionaNovaDivida(DividaDTO dividaDTO) {
		Dividas novDivida = modelMapper.map(dividaDTO, Dividas.class);
		
		return dividasRepository.save(novDivida);
	}

	public Dividas deleteDivida(long id) {
		dividasRepository.deleteById(id);
		return null;
	}

	public List<Dividas> encontraPorUsuario(long id) {
		List<Dividas> listAllByIdUserDividas = dividasRepository.findByUsuarioId(id);
		return listAllByIdUserDividas;
	}

	public Dividas alteraDiv(long id, DividaDTO dividaDTO) throws NotFoundException{	
		Optional<Dividas> validador = dividasRepository.findById(id);
		if(validador == null) {
			throw new NotFoundException();		
		}
		Dividas dividaAlterada = modelMapper.map(validador,Dividas.class);
		dividaAlterada.setId(id);
	return dividaAlterada;
	}

}
