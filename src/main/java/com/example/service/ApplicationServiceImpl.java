package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ItemList;
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
	
	    ItemList itemList = new ItemList();
	@Override
	public ItemList saveItem(String cutString,String farmer,String area){		
		ItemList itemList = new ItemList();
	    itemList.setItems(cutString);
	    itemList.setFarmer(farmer);
	    itemList.setArea(area);
	    
	    itemrepository.save(itemList);		
	    return itemList;
	}
	



	@Override
    public void deleteItem(int itemId){
		itemrepository.deleteById(itemId);
	}
	
	
}
