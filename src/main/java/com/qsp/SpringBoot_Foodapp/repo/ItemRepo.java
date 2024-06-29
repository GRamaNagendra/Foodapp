package com.qsp.SpringBoot_Foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.SpringBoot_Foodapp.dto.Item;

public interface ItemRepo extends JpaRepository<Item, Integer>{

}
