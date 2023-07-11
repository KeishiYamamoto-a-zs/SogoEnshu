package com.example.service;

import java.util.List;

import com.example.ItemList;

public interface ApplicationService {
	
	public List<ItemList> findAll();
	
	//一文字切り捨て
	public String cut(String inputForm);
    //野菜登録 
	public ItemList saveItem(String cutString,String farmer, String area);
    
    //データベース消去
    public void deleteItem(int itemId);
    
}
