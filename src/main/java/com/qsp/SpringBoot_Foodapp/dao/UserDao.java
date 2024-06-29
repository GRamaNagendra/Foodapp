package com.qsp.SpringBoot_Foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.SpringBoot_Foodapp.dto.User;
import com.qsp.SpringBoot_Foodapp.repo.UserRepo;
import com.qsp.SpringBoot_Foodapp.service.userservice;

@Repository
public class UserDao {

	@Autowired
     private UserRepo repo;
	
	public User saveuser(User user) {
		
		return repo.save(user);
		
	}
	
public User fetchuser(int id) {
Optional<User> user2 = repo.findById(id);
if (user2.isPresent()) {
	
		return repo.findById(id).get();
		
	}
else {
	return null;
}
	
}

public User updateuser(int id, User user) {
	
	User dbuser = repo.findById(id).get();
	if(dbuser!=null) {
	
		user.setUserId(id);
		return repo.save(user);
	}
	return null;
	
}


public User deleteuser(int id) {
	
	User dbuser = repo.findById(id).get();
	 repo.deleteById(id);
	
	return dbuser;
}

public List<User> fetchallusers(int id) {
	
	return repo.findAll();
	
}
	
public List<User> deleteallusers(int id) {
	
	List<User> dbuser= repo.findAll();
	 repo.deleteAll();
	 return dbuser;
	
}
}
