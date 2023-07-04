package com.example.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.ItemList;
import com.example.repository.ItemRepository;
import com.example.service.ApplicationServiceImpl;

@SpringBootTest
public class FindAllTest {
     
	@MockBean
	private ItemRepository itemRepository;
	
	@Autowired
	ApplicationServiceImpl applicationService;
	  
	
	@Test
	void test(){
		 ItemList items = new ItemList();
		 items.setId(1);
		 items.setItems("はくさい");
		 
		 List<ItemList> itemList = new ArrayList<ItemList>();
		 itemList.add(items);
		 
		 when(itemRepository.findAll()).thenReturn(itemList);
		 
		 List<ItemList> result  = applicationService.findAll();
		 
		ItemList expectedItem =result.get(0);
		assertEquals(1,expectedItem.getId());
		assertEquals("はくさい",expectedItem.getItems());
		
	}
    
}