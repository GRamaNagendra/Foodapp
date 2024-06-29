package com.qsp.SpringBoot_Foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.SpringBoot_Foodapp.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	
}
