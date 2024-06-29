package com.qsp.SpringBoot_Foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionMessage.ItemsBuilder;
import org.springframework.stereotype.Repository;

import com.qsp.SpringBoot_Foodapp.dto.Foodorder;
import com.qsp.SpringBoot_Foodapp.dto.Menu;
import com.qsp.SpringBoot_Foodapp.dto.User;
import com.qsp.SpringBoot_Foodapp.repo.Forepo;

@Repository
public class FoodOrderDao {

	@Autowired
	Forepo forepo;
	
	public  Foodorder saveFoodorder(Foodorder foodorder) {
		
		return forepo.save(foodorder);
   
	}

	public Foodorder fetchfoodorder(int id) {
		
		Optional<Foodorder> foodorder = forepo.findById(id);
		if (foodorder.isPresent()) {
			
		return forepo.findById(id).get();
	}
		else {
		return null;	
		}
		}

	public Foodorder updatefoodorder(int id, Foodorder foodorder) {
		
		Foodorder foodorder2 = forepo.findById(id).get();
		
		if(foodorder2!=null)
		{
			foodorder.setCustormerid(id);
			foodorder.setItems(foodorder.getItems());
			return forepo.save(foodorder);
		}
		else {
			return null;
		}
		}
		
		

	public Foodorder deletefoodorder(int id) {
		Foodorder dbfo = forepo.findById(id).get();
		 forepo.deleteById(id);
		 return dbfo;
	}

	public List<Foodorder> fetchallfoodorder(int id) {
		
		return forepo.findAll();
	}
public List<Foodorder> deleteallfoodorder(int id) {
	List<Foodorder> dbfo = forepo.findAll();
	 forepo.deleteAll();
	 return dbfo;
	}

}
