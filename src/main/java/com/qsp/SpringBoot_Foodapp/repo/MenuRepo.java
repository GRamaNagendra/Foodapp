package com.qsp.SpringBoot_Foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.SpringBoot_Foodapp.dto.Menu;

public interface MenuRepo extends JpaRepository<Menu, Integer>{

	
}
