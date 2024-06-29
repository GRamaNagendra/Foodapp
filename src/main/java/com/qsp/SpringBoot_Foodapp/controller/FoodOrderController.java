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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.SpringBoot_Foodapp.dao.FoodOrderDao;
import com.qsp.SpringBoot_Foodapp.dto.Foodorder;
import com.qsp.SpringBoot_Foodapp.service.FoodorderService;
import com.qsp.SpringBoot_Foodapp.util.ResponseStructure;

@RestController
@RequestMapping("/Foodcontroller")
public class FoodOrderController {

	@Autowired
	FoodorderService service;	
	
	@PostMapping
//	("/saveFoodorder")
	public ResponseEntity<ResponseStructure<Foodorder>> save(@Valid @RequestBody Foodorder foodorder ) {
		return service.savefoodorder(foodorder);
	}
	
	
	@GetMapping
//	("/fetchfoodorder")
	public ResponseEntity<ResponseStructure<Foodorder>> fetch(@RequestParam int id)
	{
		
		return service.fetchfoodorder(id);
	}
	

	@PutMapping
//	("/updatefoodorder")
	public ResponseEntity<ResponseStructure<Foodorder>> update(@RequestParam int id,@RequestBody Foodorder foodorder)
	{
		
		return service.updatefoodorder(id,foodorder);
	}
	

	@DeleteMapping
//	("/deletefoodorder")
	public ResponseEntity<ResponseStructure<Foodorder>> delete(@RequestParam int id)
	{
		
		return service.deletefoodorder(id);
	}
	
//	@GetMapping("/fetchallfoodorder")
//	public ResponseEntity<ResponseStructure<List<Foodorder>>>  fetchall(@RequestParam int id)
//	{
//		
//		return service.fetchallfoodorder(id);
//	}
//	
//	@DeleteMapping("/deleteallfoodorder")
//	public ResponseEntity<ResponseStructure<List<Foodorder>>>  deleteall(@RequestParam int id)
//	{
//		
//		return service.deleteallfoodorder(id);
//	}
}
