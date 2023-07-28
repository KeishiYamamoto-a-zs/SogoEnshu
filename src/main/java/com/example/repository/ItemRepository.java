package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.VegetableEntity;

public interface ItemRepository extends JpaRepository<VegetableEntity, Integer>{
  
	
}