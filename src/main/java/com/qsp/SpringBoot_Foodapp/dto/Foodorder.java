package com.qsp.SpringBoot_Foodapp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.Cascade;

import lombok.Data;

@Entity

public class Foodorder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custormerid;
	
	private String CustomerName;
	//@Min(1) @Max(10) also wee can use it generates its default message
	@Min(message = "1 ivu ledha koncham  pedha num ivu siggu ledha ah number ivdankhi", value = 1)
	@Max(message="10 ivu ledha koncham  chinna num ivu siggu ledha ah number ivdankhi", value = 10)
	private long cusomerphone;
	private String customerAddress;
	private double totalprice;
	
	
	@OneToMany (cascade = CascadeType.ALL)
	List<Item> items;


	public int getCustormerid() {
		return custormerid;
	}


	public void setCustormerid(int custormerid) {
		this.custormerid = custormerid;
	}


	public String getCustomerName() {
		return CustomerName;
	}


	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}


	public long getCusomerphone() {
		return cusomerphone;
	}


	public void setCusomerphone(long cusomerphone) {
		this.cusomerphone = cusomerphone;
	}


	public String getCustomerAddress() {
		return customerAddress;
	}


	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}


	public double getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
	
}
