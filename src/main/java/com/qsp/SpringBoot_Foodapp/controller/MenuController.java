package com.qsp.SpringBoot_Foodapp.controller;

import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qsp.SpringBoot_Foodapp.dto.Menu;
import com.qsp.SpringBoot_Foodapp.service.Menuservice;
import com.qsp.SpringBoot_Foodapp.service.userservice;
import com.qsp.SpringBoot_Foodapp.util.ResponseStructure;
import com.qsp.SpringBoot_Foodapp.dto.Menu;

@RestController
public class MenuController {

	@Autowired
	Menuservice menuservice;
	
	@PostMapping("/savemenu")
	public ResponseEntity<ResponseStructure<Menu>> savemenu(@RequestBody Menu menu) {
		return menuservice.savemenu(menu);
	}
	
	@GetMapping("/getmenu")
	public ResponseEntity<ResponseStructure<Menu>> getmenu(@RequestParam int id) {
		return menuservice.fetchMenu(id);
	}
	
	
	@PutMapping("/updateMenu")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestParam int id, @RequestBody Menu Menu)
	{
		return menuservice.updateMenu(id, Menu);
	}
	
	@DeleteMapping("/deleteMenu")
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(@RequestParam int id)
	{
		return menuservice.deleteMenu(id);
	}
	
	@GetMapping("/fetchallMenu")
	public ResponseEntity<ResponseStructure<List<Menu>>> fetchallMenu(@RequestParam int id)
	{
	return menuservice.fetchallMenus(id);
	}
	
	@DeleteMapping("/deleteallMenu")
	public ResponseEntity<ResponseStructure<List<Menu>>> deleteallMenu(@RequestParam int id)
	{
	return menuservice.deleteallMenus(id);
	}
	
	
}
