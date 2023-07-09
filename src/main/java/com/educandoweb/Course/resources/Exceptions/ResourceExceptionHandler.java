package com.educandoweb.Course.resources.Exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.Course.Services.Exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //Intercepta as excessoes que ocorrerem para q esse objeto trate
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) //Essa anotation fala que esse método vai intercepta uma excessao da classe ResouceNot...
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not Found";
		//Qual vai ser o status da resposta que deu essa excessão?
		HttpStatus status =  HttpStatus.NOT_FOUND;
		
		//Criando o objeto erro
		StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
