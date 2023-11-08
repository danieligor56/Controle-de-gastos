package br.com.controle.de.gastos.controle.de.gastos.Infra;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.controle.de.gastos.controle.de.gastos.Repository.UsuarioRepository;
import br.com.controle.de.gastos.controle.de.gastos.Services.TokenService;
import ch.qos.logback.core.subst.Token;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.var;

@Component
public class SecurityFilter extends OncePerRequestFilter{
	@Autowired
	TokenService tokenService;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		var token = this.recoverToken(request);
				if(token != null) {
					var login = tokenService.validarToken(token);
					UserDetails user = usuarioRepository.findByLogin(login);
					
					var autenticador = new UsernamePasswordAuthenticationToken(user, null,user.getAuthorities());
					SecurityContextHolder.getContext().setAuthentication(autenticador);				}
				
				filterChain.doFilter(request, response);
			}
	
	private String recoverToken(HttpServletRequest request) {
		var authHeader = request.getHeader("Authorization");
		if(authHeader == null) return null;
		return authHeader.replace("Bearer", "");
	}

}
