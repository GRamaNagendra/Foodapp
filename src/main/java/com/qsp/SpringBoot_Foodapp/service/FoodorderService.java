package com.qsp.SpringBoot_Foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.SpringBoot_Foodapp.dao.FoodOrderDao;
import com.qsp.SpringBoot_Foodapp.dto.Foodorder;
import com.qsp.SpringBoot_Foodapp.dto.Item;
import com.qsp.SpringBoot_Foodapp.dto.Menu;
import com.qsp.SpringBoot_Foodapp.exception.FoodorderIdNotFound;
import com.qsp.SpringBoot_Foodapp.util.ResponseStructure;

@Service
public class FoodorderService {

@Autowired
private FoodOrderDao dao;


public ResponseEntity<ResponseStructure<Foodorder>> savefoodorder(Foodorder foodorder)
{
List<Item> list= foodorder.getItems();
double totalprice=0;
for(Item item : list)
{
	totalprice=totalprice+item.getItemprice()*item.getItemQuantity(); 
}
foodorder.setTotalprice(totalprice);


ResponseStructure<Foodorder> responseStructure = new ResponseStructure<Foodorder>();

responseStructure.setStatus(HttpStatus.CREATED.value());
responseStructure.setMessage("Sucessfully saved");
responseStructure.setData(dao.saveFoodorder(foodorder));
return new ResponseEntity<ResponseStructure<Foodorder>>(responseStructure, HttpStatus.CREATED);

}


public ResponseEntity<ResponseStructure<Foodorder>> fetchfoodorder(int id)
{

ResponseStructure<Foodorder> responseStructure = new ResponseStructure<Foodorder>();
Foodorder foodorder2 =dao.fetchfoodorder(id);
if(foodorder2!=null) {

responseStructure.setStatus(HttpStatus.FOUND.value());
responseStructure.setMessage("Sucessfully Fetched");
responseStructure.setData(dao.fetchfoodorder(id));
return new ResponseEntity<ResponseStructure<Foodorder>>(responseStructure, HttpStatus.FOUND);
}
else {
throw new FoodorderIdNotFound();
}
	
}

public ResponseEntity<ResponseStructure<Foodorder>> updatefoodorder(int id, Foodorder foodorder) {
	
	List<Item> list= foodorder.getItems();
	double totalprice=0;
	for(Item item : list)
	{
		totalprice=totalprice+item.getItemprice()*item.getItemQuantity(); 
	}
	foodorder.setTotalprice(totalprice);
ResponseStructure<Foodorder> responseStructure = new ResponseStructure<Foodorder>();
Foodorder foodorder2 =dao.fetchfoodorder(id);
if(foodorder2!=null) {


responseStructure.setStatus(HttpStatus.OK.value());
responseStructure.setMessage("Sucessfully Updated");
responseStructure.setData(dao.updatefoodorder(id,foodorder));
return new ResponseEntity<ResponseStructure<Foodorder>>(responseStructure, HttpStatus.OK);
}
else {
throw new FoodorderIdNotFound();
}
	
}


public ResponseEntity<ResponseStructure<Foodorder>> deletefoodorder(int id) {

ResponseStructure<Foodorder> responseStructure = new ResponseStructure<Foodorder>();
Foodorder foodorder2 =dao.fetchfoodorder(id);
if(foodorder2!=null) {

responseStructure.setStatus(HttpStatus.OK.value());
responseStructure.setMessage("Sucessfully Deleted");
responseStructure.setData(dao.deletefoodorder(id));
return new ResponseEntity<ResponseStructure<Foodorder>>(responseStructure, HttpStatus.FOUND);
}
else {
throw new FoodorderIdNotFound();
}
}


public ResponseEntity<ResponseStructure<List<Foodorder>>> fetchallfoodorder(int id) {

ResponseStructure<List<Foodorder>> responseStructure = new ResponseStructure<List<Foodorder>>();
Foodorder foodorder2 =dao.fetchfoodorder(id);
if(foodorder2!=null) {

responseStructure.setStatus(HttpStatus.OK.value());
responseStructure.setMessage("Sucessfully Fetched all");
responseStructure.setData(dao.fetchallfoodorder(id));
return new ResponseEntity<ResponseStructure<List<Foodorder>>>(responseStructure, HttpStatus.OK);
}
else {
throw new FoodorderIdNotFound();
}
}


public ResponseEntity<ResponseStructure<List<Foodorder>>> deleteallfoodorder(int id) {

ResponseStructure<List<Foodorder>> responseStructure = new ResponseStructure<List<Foodorder>>();
Foodorder foodorder2 =dao.fetchfoodorder(id);
if(foodorder2!=null) {

responseStructure.setStatus(HttpStatus.OK.value());
responseStructure.setMessage("Sucessfully Delete all");
responseStructure.setData(dao.deleteallfoodorder(id));
return new ResponseEntity<ResponseStructure<List<Foodorder>>>(responseStructure, HttpStatus.OK);
}
else {
throw new FoodorderIdNotFound();
}	
}



}

