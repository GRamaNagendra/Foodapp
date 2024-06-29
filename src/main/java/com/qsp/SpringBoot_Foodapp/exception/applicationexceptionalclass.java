package com.qsp.SpringBoot_Foodapp.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.SpringBoot_Foodapp.dto.User;
import com.qsp.SpringBoot_Foodapp.util.ResponseStructure;

@RestControllerAdvice
public class applicationexceptionalclass extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> UserIdNotFound(UserIdNotFound userIdNotfound)
	{
	ResponseStructure<String> responseStructure = new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
	responseStructure.setMessage("UserId not found in the Database");
//	responseStructure.setData(userIdNotfound.getMessage());
	return new ResponseEntity<ResponseStructure<String>> (responseStructure,HttpStatus.NOT_FOUND);
	
	}
	
	@ExceptionHandler(MenuIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>>MenuIdNotFound(MenuIdNotFound menuIdNotfound)
	{
	ResponseStructure<String> responseStructure = new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
	responseStructure.setMessage("MenuId not found in the Database");
//	responseStructure.setData(productIdNotfound.getMessage());
    return new ResponseEntity<ResponseStructure<String>> (responseStructure,HttpStatus.NOT_FOUND);
	
	}
	
	@ExceptionHandler(FoodorderIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>>FoodorderIdNotFound(FoodorderIdNotFound foodorderIdNotFound)
	{
	ResponseStructure<String> responseStructure = new ResponseStructure<>();
	responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
	responseStructure.setMessage("FoodorderId not found in the Database");
//	responseStructure.setData(productIdNotfound.getMessage());
    return new ResponseEntity<ResponseStructure<String>> (responseStructure,HttpStatus.NOT_FOUND);
	
	}
	
	

	@Override                  
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errors = ex.getAllErrors();
		Map<String, String> map = new HashMap<>();
		for (ObjectError error : errors) {
			String message = error.getDefaultMessage();
			String fieldName = ((FieldError) error).getField();
			map.put(fieldName, message);
		}
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
}
