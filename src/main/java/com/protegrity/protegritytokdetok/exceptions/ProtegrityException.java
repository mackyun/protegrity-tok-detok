package com.protegrity.protegritytokdetok.exceptions;

public class ProtegrityException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	 public ProtegrityException(String errorMesg) { 
		  super(errorMesg);
	   }
}
