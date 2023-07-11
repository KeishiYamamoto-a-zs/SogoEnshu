package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.vegetable.model.ItemList;
import com.example.repository.ItemRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	private ItemRepository itemrepository;
	
	@Override
	public List<ItemList> findAll(){
		List<ItemList>vegetables = itemrepository.findAll() ;
	
		return vegetables;
	}
	
	
	@Override
	public String cut(String form) {
		//itemListの値を取るためにgetItemsをする
		String str = form;
        String truncatedStr = str.substring(0, str.length() - 1);

	    return truncatedStr;
	}
	
	
	@Override
	public ItemList saveItem(ItemList itemList){		
	    
	    itemrepository.save(itemList);		
	    return itemList;
	}
	
	@Override
	public ItemList updateItem(ItemList itemList){		
	    
	    itemrepository.save(itemList);		
	    return itemList;
	}
	
    
	public ItemList getVegetableId(int itemId) {
		Optional<ItemList> items = itemrepository.findById(itemId);
	    ItemList item = items.orElse(null);
		return item;
		
	}


	@Override
    public void deleteItem(int itemId){
		itemrepository.deleteById(itemId);
	}
	
	
}
