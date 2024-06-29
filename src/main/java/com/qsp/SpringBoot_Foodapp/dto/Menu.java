package com.qsp.SpringBoot_Foodapp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import lombok.Data;

@Entity

public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int MenuId;
private String MenuName;
private String MenuCateogry;


@OneToMany(cascade = CascadeType.ALL)
private List<Product> products;


public int getMenuId() {
	return MenuId;
}


public void setMenuId(int menuId) {
	MenuId = menuId;
}


public String getMenuName() {
	return MenuName;
}


public void setMenuName(String menuName) {
	MenuName = menuName;
}


public String getMenuCateogry() {
	return MenuCateogry;
}


public void setMenuCateogry(String menuCateogry) {
	MenuCateogry = menuCateogry;
}


public List<Product> getProducts() {
	return products;
}


public void setProducts(List<Product> products) {
	this.products = products;
}



}
