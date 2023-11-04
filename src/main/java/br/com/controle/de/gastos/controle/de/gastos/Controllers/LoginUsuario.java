package br.com.controle.de.gastos.controle.de.gastos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.controle.de.gastos.controle.de.gastos.DTO.AuthDTO;
import br.com.controle.de.gastos.controle.de.gastos.DTO.UsuarioDTO;
import br.com.controle.de.gastos.controle.de.gastos.Entities.Usuario;
import br.com.controle.de.gastos.controle.de.gastos.Repository.UsuarioRepository;
import br.com.controle.de.gastos.controle.de.gastos.Services.UsuarioService;
import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.validation.Valid;
import lombok.var;

@RestController
@RequestMapping("auth")

public class LoginUsuario {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/login")
	public ResponseEntity login (@RequestBody @Valid AuthDTO authDTO){
		
		var usernamePassword = new UsernamePasswordAuthenticationToken(authDTO.login(),authDTO.plvPass());
		var auth =this.authenticationManager.authenticate(usernamePassword);
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/register")
	public ResponseEntity<Usuario> registrarNovoUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
		usuarioService.registraUsuario(usuarioDTO);
		return ResponseEntity.ok().build();
	}

}
