package com.qsp.SpringBoot_Foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.SpringBoot_Foodapp.dto.Menu;
import com.qsp.SpringBoot_Foodapp.dto.User;
import com.qsp.SpringBoot_Foodapp.dto.Menu;
import com.qsp.SpringBoot_Foodapp.repo.MenuRepo;

@Repository
public class MenuDao {

	@Autowired
	MenuRepo menuRepo;
	
	public Menu savemenu(Menu menu)
	{
		return menuRepo.save(menu);
	}
	
	
	
public Menu fetchMenu(int id) {
	
	Optional<Menu> menu = menuRepo.findById(id);
	if (menu.isPresent()) {
		
		return menuRepo.findById(id).get();
		
	}
	else {
		return null;
	}
	}

public Menu updateMenu(int id, Menu menu) {
	
	Menu dbMenu = menuRepo.findById(id).get();
	if(dbMenu!=null) {
	
		menu.setMenuId(id);
		menu.setProducts(menu.getProducts());
		return menuRepo.save(menu);
	}
	return null;
	
}


public Menu deleteMenu(int id) {
	
	Menu dbMenu = menuRepo.findById(id).get();
	 menuRepo.deleteById(id);
	
	return dbMenu;
}

public List<Menu> fetchallMenus(int id) {
	
	return menuRepo.findAll();
	
}
	
public List<Menu> deleteallMenus(int id) {
	
	List<Menu> dbMenu= menuRepo.findAll();
	 menuRepo.deleteAll();
	 return dbMenu;
	
}
	
	
	
	
	
	
}
