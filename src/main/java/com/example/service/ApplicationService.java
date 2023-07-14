package com.example.service;

import java.util.List;

import com.example.domain.vegetable.model.ItemList;

public interface ApplicationService {
	
	public List<ItemList> findAll();
	
	//一文字切り捨て
	public String cut(String inputForm);
    //野菜登録 
	public ItemList saveItem(ItemList itemList);
	//野菜更新
	public ItemList updateItem(ItemList itemList);
    
    //データベース消去
    public void deleteItem(int itemId);
    
}
