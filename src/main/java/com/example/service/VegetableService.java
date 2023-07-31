package com.example.service;

import java.util.List;

import com.example.Entity.VegetableEntity;
import com.example.form.InputForm;

public interface VegetableService {
	
	public List<VegetableEntity> findAll();
	
	public VegetableEntity saveItem(VegetableEntity itemList);

	public VegetableEntity updateItem(VegetableEntity itemList);
	
	public VegetableEntity getVegetableById(int itemId);
    
	public VegetableEntity copyToEntity(String cutString,InputForm inputForm);
	
    public void deleteItem(int itemId);
    
}
