package br.com.controle.de.gastos.controle.de.gastos.Services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import br.com.controle.de.gastos.controle.de.gastos.Entities.Usuario;

@Service
public class TokenService {

	@Value("${api.security.token.secret}")
	private String secret;

	public String geradorToken(Usuario usuario) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create().withIssuer("Controle-de-Gasto").withSubject(usuario.getLogin())
					.withExpiresAt(genExpirationDate()).sign(algorithm);
			return token;
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Erro durante a execussão do token", exception);
		}

	}

	public String validarToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm).withIssuer("Controle-de-Gastos").build().verify(token).getSubject();

		} catch (JWTVerificationException exception) {
			return "";
		}
	}

	private Instant genExpirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}

}
