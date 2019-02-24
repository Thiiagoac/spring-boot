package com.webstore.cursomc.services.exception;

public class DataIntegrityException extends RuntimeException{
	private static final long serialVersionUID =1l;
	
	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	public DataIntegrityException(String msg,Throwable cause) {
		super(msg,cause);
	}
	
}
