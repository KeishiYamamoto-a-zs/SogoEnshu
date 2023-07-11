package com.example.repository;
import  org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.vegetable.model.ItemList;

public interface ItemRepository extends JpaRepository<ItemList, Integer>{
  
	
}