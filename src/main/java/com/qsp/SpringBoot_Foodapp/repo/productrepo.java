package com.qsp.SpringBoot_Foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qsp.SpringBoot_Foodapp.dto.Product;

public interface productrepo extends JpaRepository<Product, Integer>{

}
