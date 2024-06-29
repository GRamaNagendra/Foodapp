package com.qsp.SpringBoot_Foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.SpringBoot_Foodapp.dto.Foodorder;

public interface Forepo extends JpaRepository<Foodorder, Integer>{

}
