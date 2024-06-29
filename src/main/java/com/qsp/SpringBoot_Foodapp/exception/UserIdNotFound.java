package com.qsp.SpringBoot_Foodapp.exception;

public class UserIdNotFound extends RuntimeException{

	private String Message = "data ivali ani telyadha";
	
	
	public String getMessage() {
		return Message;
	}
    
	public UserIdNotFound () {
		
	
	}
}
