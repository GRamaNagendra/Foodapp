package com.qsp.SpringBoot_Foodapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity

public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ItemId;
	private String ItemName;
	private double Itemprice;
	private String ItemDescription;
	private int ItemQuantity;
	

	public int getItemId() {
		return ItemId;
	}
	public void setItemId(int ItemId) {
		this.ItemId = ItemId;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String ItemName) {
		this.ItemName = ItemName;
	}
	public double getItemprice() {
		return Itemprice;
	}
	public void setItemprice(double Itemprice) {
		this.Itemprice = Itemprice;
	}
	public String getItemDescription() {
		return ItemDescription;
	}
	public void setItemDescription(String ItemDescription) {
		this.ItemDescription = ItemDescription;
	}
	
	public int getItemQuantity() {
		return ItemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		ItemQuantity = itemQuantity;
	}
	
}
