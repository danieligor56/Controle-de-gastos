package br.com.controle.de.gastos.controle.de.gastos.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebSecConfig {
	
				public void addCorsMappings(CorsRegistry registry) {

			registry.addMapping("/api/v1/**")
				.allowedOrigins("http://25.6.206.68:8080")
				.allowedMethods("POST", "DELETE")
				.allowedHeaders("/login", "header2", "header3")
				.exposedHeaders("header1", "header2")
				.allowCredentials(true).maxAge(3600);

	
		}
	}


