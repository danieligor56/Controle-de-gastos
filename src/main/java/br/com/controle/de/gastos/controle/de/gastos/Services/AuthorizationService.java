package br.com.controle.de.gastos.controle.de.gastos.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.controle.de.gastos.controle.de.gastos.Repository.UsuarioRepository;

@Service
public class AuthorizationService implements UserDetailsService{
	
	@Autowired
	UsuarioRepository usuarioRepository;  

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return usuarioRepository.findByLogin(login);
	}

}
