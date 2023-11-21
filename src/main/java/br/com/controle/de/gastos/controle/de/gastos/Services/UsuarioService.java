package br.com.controle.de.gastos.controle.de.gastos.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.controle.de.gastos.controle.de.gastos.DTO.UsuarioIdDTO;
import br.com.controle.de.gastos.controle.de.gastos.DTO.AuthDTO;
import br.com.controle.de.gastos.controle.de.gastos.DTO.UsuarioDTO;
import br.com.controle.de.gastos.controle.de.gastos.Entities.Usuario;
import br.com.controle.de.gastos.controle.de.gastos.Entities.UsuarioRole;
import br.com.controle.de.gastos.controle.de.gastos.Exeptions.BadRequestExeption;
import br.com.controle.de.gastos.controle.de.gastos.Repository.UsuarioRepository;
import io.swagger.v3.core.util.Json;
import jakarta.validation.Valid;
import lombok.var;

@Service
public class UsuarioService {

@Autowired
ModelMapper modelMapper;

@Autowired
UsuarioRepository usuarioRepository;

@Autowired
AuthenticationManager authenticationManager;

@Autowired
TokenService tokenService;

public Usuario registraUsuario(UsuarioDTO usuarioDTO) {
	
	if(usuarioDTO.login().isEmpty() || usuarioDTO.login().isBlank() ) {
		throw new BadRequestExeption("O campo de login não pode estar em branco ou ser nulo. Por favor, forneça um login válido.");
	}
	
	if(usuarioDTO.nome().isEmpty() || usuarioDTO.nome().isBlank()) {
		throw new BadRequestExeption("O campo do nome não pode estar em branco ou ser nulo. Por favor, forneça um nome válido.");
	}
	
	if(usuarioDTO.plvPass().isEmpty() || usuarioDTO.plvPass().isBlank()) {
		throw new BadRequestExeption("A senha não pode estar em branco ou ser nula. Por favor, forneça uma senha válida.");
	}
	
	if(this.usuarioRepository.findByLogin(usuarioDTO.login()) != null) {
		throw new BadRequestExeption("Já existe um usuário cadastrado com esse Login");
	}
	
		String passWordEncrypted  = new BCryptPasswordEncoder().encode(usuarioDTO.plvPass());
		
		Usuario novoUsuario = new Usuario(usuarioDTO.nome(),usuarioDTO.login(),passWordEncrypted,usuarioDTO.role());
		novoUsuario.setRole(UsuarioRole.USER);
	return usuarioRepository.save(novoUsuario);
}

public Usuario login(@Valid AuthDTO authDTO) {
	var usernamePassword = new UsernamePasswordAuthenticationToken(authDTO.login(), authDTO.plvPass());
	var auth = this.authenticationManager.authenticate(usernamePassword);
	@SuppressWarnings("unused")
	var token = tokenService.geradorToken((Usuario) auth.getPrincipal());
	
	
	return null;
}


 public UsuarioIdDTO returnUser(String login) { 
	 Usuario usuarioID = usuarioRepository.findUsuarioByLogin(login);
	 var iduser = modelMapper.map(usuarioID, UsuarioIdDTO.class);
	 return iduser;
 
 }




}
