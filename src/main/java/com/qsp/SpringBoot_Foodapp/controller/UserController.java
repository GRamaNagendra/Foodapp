package com.qsp.SpringBoot_Foodapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qsp.SpringBoot_Foodapp.dto.User;
import com.qsp.SpringBoot_Foodapp.service.userservice;
import com.qsp.SpringBoot_Foodapp.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {

	@Autowired
	private userservice userservice;
	
	
//	http://localhost:8080/swagger-ui.html#/food-order-controller/saveUsingPOST
	
	@ApiOperation(value="It Save's the User Data")
	@ApiResponses ({@ApiResponse(code=200 , message ="user saved successfully"),
	@ApiResponse(code=400, message="fields cannot be null or blank") })
	@PostMapping("/saveuser")
	public ResponseEntity<ResponseStructure<User>> saveuser(@Valid @RequestBody User user)
	{
		return userservice.saveuser(user);
	}
	
	@GetMapping("/fetchuser")
	public ResponseEntity<ResponseStructure<User>>  fetchuser(@Valid @RequestParam int id)
	{
	return userservice.fetchuser(id);
	}
	
	@PutMapping("/updateuser")
	public ResponseEntity<ResponseStructure<User>>  updateuser(@Valid @RequestParam int id,@Valid @RequestBody User user)
	{
		return userservice.updateuser(id, user);
	}
	
	@DeleteMapping("/deleteuser")
	public ResponseEntity<ResponseStructure<User>>  deleteuser(@Valid @RequestParam int id)
	{
		return userservice.deleteuser(id);
	}
	
	@GetMapping("/fetchalluser")
	public ResponseEntity<ResponseStructure<List<User>>> fetchalluser(@RequestParam int id)
	{
	return userservice.fetchallusers(id);
	}
	
	@DeleteMapping("/deletealluser")
	public ResponseEntity<ResponseStructure<List<User>>> deletealluser(@RequestParam int id)
	{
	return userservice.deleteallusers(id);
	}
	
	
}
