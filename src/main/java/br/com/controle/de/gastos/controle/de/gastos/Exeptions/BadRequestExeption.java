package br.com.controle.de.gastos.controle.de.gastos.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestExeption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BadRequestExeption() {
		super();
	}
	
	public BadRequestExeption(String message) {
		super(message);
	}

	public BadRequestExeption(Throwable cause) {
		super(cause);
	}

	public BadRequestExeption(String message, Throwable cause) {
		super(message,cause);
	}

}
