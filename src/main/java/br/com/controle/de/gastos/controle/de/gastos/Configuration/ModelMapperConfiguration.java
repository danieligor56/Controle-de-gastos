package br.com.controle.de.gastos.controle.de.gastos.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
