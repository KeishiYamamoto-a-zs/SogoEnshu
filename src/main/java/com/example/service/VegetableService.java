package com.example.service;

import java.util.List;

import com.example.Entity.VegetableEntity;
import com.example.form.InputForm;

public interface VegetableService {
	
	public List<VegetableEntity> findAll();
	
    //野菜登録 
	public VegetableEntity saveItem(VegetableEntity itemList);
	//野菜更新
	public VegetableEntity updateItem(VegetableEntity itemList);
	
	public VegetableEntity getVegetableId(int itemId);
    
	public VegetableEntity copyToEntity(String cutString,InputForm inputForm);
	
    //データベース消去
    public void deleteItem(int itemId);
    
}
