package com.qsp.SpringBoot_Foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
 

import com.qsp.SpringBoot_Foodapp.dao.UserDao;
import com.qsp.SpringBoot_Foodapp.dto.User;
import com.qsp.SpringBoot_Foodapp.exception.MenuIdNotFound;
import com.qsp.SpringBoot_Foodapp.repo.UserRepo;
import com.qsp.SpringBoot_Foodapp.util.ResponseStructure;

@Service
public class userservice {

@Autowired
UserDao dao;



public ResponseEntity<ResponseStructure<User>> saveuser(User user) {

	ResponseStructure<User> responseStructure = new ResponseStructure<User>();
	responseStructure.setStatus(HttpStatus.CREATED.value());
	responseStructure.setMessage("Sucessfully saved");
	responseStructure.setData(dao.saveuser(user));
	return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.CREATED);
	
}

public ResponseEntity<ResponseStructure<User>> fetchuser(int id) {
	
	
	ResponseStructure<User> responseStructure = new ResponseStructure<User>();
    User user =dao.fetchuser(id);
    if(user!=null) {
	responseStructure.setStatus(HttpStatus.FOUND.value());
	responseStructure.setMessage("Sucessfully Fetched");
	responseStructure.setData(dao.fetchuser(id));
	return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.FOUND);
    }
    else {
    throw new MenuIdNotFound();
    }
}

public ResponseEntity<ResponseStructure<User>> updateuser(int id, User user) {

	ResponseStructure<User> responseStructure = new ResponseStructure<User>();
	  User user2 =dao.fetchuser(id);
	    if(user2!=null) {
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Sucessfully Updated");
	responseStructure.setData(dao.updateuser(id, user));
	return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
	    }
	    else {
	    throw new MenuIdNotFound();
	    }

}


public ResponseEntity<ResponseStructure<User>> deleteuser(int id) {
	
	ResponseStructure<User> responseStructure = new ResponseStructure<User>();
	 User user2 =dao.fetchuser(id);
	    if(user2!=null) {
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Sucessfully Deleted");
	responseStructure.setData( dao.deleteuser(id));
	 return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
}
else {
throw new MenuIdNotFound();
}

}

public ResponseEntity<ResponseStructure<List<User>>> fetchallusers(int id) {
	ResponseStructure<List<User>> responseStructure = new ResponseStructure<List<User>>();
	 User user2 =dao.fetchuser(id);
	    if(user2!=null) {
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Sucessfully Fetched all files");
	responseStructure.setData( dao.fetchallusers(id));
	return new ResponseEntity<ResponseStructure<List<User>>>(responseStructure, HttpStatus.OK);

}
else {
throw new MenuIdNotFound();
}
}

public ResponseEntity<ResponseStructure<List<User>>>  deleteallusers(int id) {

	ResponseStructure<List<User>> responseStructure = new ResponseStructure<List<User>>();
	 User user2 =dao.fetchuser(id);
	    if(user2!=null) {
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Sucessfully Deleted all files");
	responseStructure.setData( dao.deleteallusers(id));
	return new ResponseEntity<ResponseStructure<List<User>>>(responseStructure, HttpStatus.OK);
	
}
else {
throw new MenuIdNotFound();
}
}
}
