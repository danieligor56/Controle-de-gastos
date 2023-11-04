package br.com.controle.de.gastos.controle.de.gastos.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.controle.de.gastos.controle.de.gastos.DTO.UsuarioDTO;
import br.com.controle.de.gastos.controle.de.gastos.Entities.Usuario;
import br.com.controle.de.gastos.controle.de.gastos.Entities.UsuarioRole;
import br.com.controle.de.gastos.controle.de.gastos.Exeptions.BadRequestExeption;
import br.com.controle.de.gastos.controle.de.gastos.Repository.UsuarioRepository;

@Service
public class UsuarioService {
@Autowired
UsuarioRepository usuarioRepository;

@Autowired
ModelMapper modelMapper;

public Usuario registraUsuario(UsuarioDTO usuarioDTO) {
	if(this.usuarioRepository.findByLogin(usuarioDTO.login()) != null) {
		throw new BadRequestExeption("Já existe um usuário cadastrado com esse Login");
	}
	
		String passWordEncrypted  = new BCryptPasswordEncoder().encode(usuarioDTO.plvPass());
		
		Usuario novoUsuario = new Usuario(usuarioDTO.nome(),usuarioDTO.login(),passWordEncrypted,usuarioDTO.role());
		novoUsuario.setRole(UsuarioRole.USER);
	return usuarioRepository.save(novoUsuario);
}

}
