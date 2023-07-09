package com.educandoweb.Course.Services.Exceptions;

public class ResourceNotFoundException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	
	//Não encontrou o Id
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id"+id);
	}
	
	

}
