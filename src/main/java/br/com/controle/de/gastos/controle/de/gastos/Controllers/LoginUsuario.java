package br.com.controle.de.gastos.controle.de.gastos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.de.gastos.controle.de.gastos.DTO.AuthDTO;
import br.com.controle.de.gastos.controle.de.gastos.DTO.LoginResponseDTO;
import br.com.controle.de.gastos.controle.de.gastos.DTO.UsuarioDTO;
import br.com.controle.de.gastos.controle.de.gastos.Entities.Usuario;
import br.com.controle.de.gastos.controle.de.gastos.Services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/auth")

public class LoginUsuario {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UsuarioService usuarioService;

	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthDTO authDTO) {
		usuarioService.login(authDTO);
		return ResponseEntity.ok().body(usuarioService.returnUser(authDTO.login()));
	}

	@PostMapping("/register")
	public ResponseEntity<Usuario> registrarNovoUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {

		usuarioService.registraUsuario(usuarioDTO);
		return ResponseEntity.ok().build();
	}

}
