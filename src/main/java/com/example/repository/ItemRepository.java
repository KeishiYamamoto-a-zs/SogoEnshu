package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.vegetable.model.VegetableEntity;

public interface ItemRepository extends JpaRepository<VegetableEntity, Integer>{
  
	
}