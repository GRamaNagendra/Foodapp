package com.qsp.SpringBoot_Foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.SpringBoot_Foodapp.dao.MenuDao;
import com.qsp.SpringBoot_Foodapp.dto.Menu;
import com.qsp.SpringBoot_Foodapp.dto.User;
import com.qsp.SpringBoot_Foodapp.exception.MenuIdNotFound;
import com.qsp.SpringBoot_Foodapp.exception.UserIdNotFound;
import com.qsp.SpringBoot_Foodapp.repo.MenuRepo;
import com.qsp.SpringBoot_Foodapp.util.ResponseStructure;

@Service
public class Menuservice {


	@Autowired
	MenuDao dao;
	
	public ResponseEntity<ResponseStructure<Menu>> savemenu(Menu menu)
	{
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Sucessfully saved");
		responseStructure.setData(dao.savemenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.CREATED);
	
	}
	
	
	
public ResponseEntity<ResponseStructure<Menu>> fetchMenu(int id) {
	
	ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
	 Menu menu =dao.fetchMenu(id);
	    if(menu!=null) {
	responseStructure.setStatus(HttpStatus.FOUND.value());
	responseStructure.setMessage("Sucessfully saved");
	responseStructure.setData(dao.fetchMenu(id));
	return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.FOUND);
	    }
	    else {
	    throw new MenuIdNotFound();
	    }
	}

public ResponseEntity<ResponseStructure<Menu>> updateMenu(int id, Menu menu) {
	 Menu menu2 =dao.fetchMenu(id);
	    if(menu2!=null) {
	ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Sucessfully Updated");
	responseStructure.setData(dao.updateMenu(id, menu));
	return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
	
}
else {
	  throw new MenuIdNotFound();
}
}


public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int id) {
	
	ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
	Menu menu2 =dao.fetchMenu(id);
    if(menu2!=null) {
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Successfully deleted");
	responseStructure.setData(dao.deleteMenu(id));
	return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
	
}
else {
	  throw new MenuIdNotFound();
}
}

public ResponseEntity<ResponseStructure<List<Menu>>> fetchallMenus(int id) {
	
	ResponseStructure<List<Menu>> responseStructure = new ResponseStructure<List<Menu>>();
	Menu menu2 =dao.fetchMenu(id);
    if(menu2!=null) {
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("All Menu are Sucessfully Fetched");
	responseStructure.setData(dao.fetchallMenus(id));
	return new ResponseEntity<ResponseStructure<List<Menu>>>(responseStructure, HttpStatus.OK);
}
else {
	  throw new MenuIdNotFound();
}
}
	
public ResponseEntity<ResponseStructure<List<Menu>>> deleteallMenus(int id) {
	
	ResponseStructure<List<Menu>> responseStructure = new ResponseStructure<List<Menu>>();
	Menu menu2 =dao.fetchMenu(id);
    if(menu2!=null) {
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("All Menus are Deleted");
	responseStructure.setData(dao.deleteallMenus(id));
	return new ResponseEntity<ResponseStructure<List<Menu>>>(responseStructure, HttpStatus.OK);

}
else {
	  throw new MenuIdNotFound();
}
}
	
}
