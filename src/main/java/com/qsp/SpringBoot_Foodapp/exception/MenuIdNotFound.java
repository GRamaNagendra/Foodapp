package com.qsp.SpringBoot_Foodapp.exception;

public class MenuIdNotFound extends RuntimeException{

	private String Message = "product Id Not Found";
	
	
	public String getMessage() {
		return Message;
	}
    
	public MenuIdNotFound () {
		
	
	}
}


