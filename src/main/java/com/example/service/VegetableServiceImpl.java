package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.VegetableEntity;
import com.example.form.InputForm;
import com.example.repository.ItemRepository;

@Service
public class VegetableServiceImpl implements VegetableService {
	
	@Autowired
	private ItemRepository itemrepository;
	
	@Override
	public List<VegetableEntity> findAll(){
		List<VegetableEntity>vegetables = itemrepository.findAll() ;
	
		return vegetables;
	}	
	
	@Override
	public VegetableEntity saveItem(VegetableEntity itemList){		
	    
	    itemrepository.save(itemList);		
	    return itemList;
	}
	
	@Override
	public VegetableEntity updateItem(VegetableEntity itemList){		
	    
	    itemrepository.save(itemList);		
	    return itemList;
	}
	
    @Override
	public VegetableEntity getVegetableById(int itemId) {
		Optional<VegetableEntity> items = itemrepository.findById(itemId);
	    VegetableEntity item = items.orElse(null);
		return item;
		
	}
	
	@Override
	public VegetableEntity copyToEntity(String cutString,InputForm inputForm){
		VegetableEntity vegetableEntity = new VegetableEntity();
  		vegetableEntity.setId(inputForm.getId());
  		vegetableEntity.setItems(cutString);
	    vegetableEntity.setFarmer(inputForm.getFarmer());
	    vegetableEntity.setArea(inputForm.getArea());
		
		
		return vegetableEntity;
		
	}


	@Override
    public void deleteItem(int itemId){
		itemrepository.deleteById(itemId);
	}
	
	
}
