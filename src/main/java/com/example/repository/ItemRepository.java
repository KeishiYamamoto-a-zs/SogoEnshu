package com.example.repository;
import  org.springframework.data.jpa.repository.JpaRepository;

import com.example.ItemList;

public interface ItemRepository extends JpaRepository<ItemList, Long>{
	
	
}