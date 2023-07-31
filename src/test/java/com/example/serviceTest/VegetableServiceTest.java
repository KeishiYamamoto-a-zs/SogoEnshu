package com.example.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.Entity.VegetableEntity;
import com.example.repository.ItemRepository;
import com.example.service.VegetableServiceImpl;

@SpringBootTest
public class VegetableServiceTest {
     
	@MockBean
	private ItemRepository itemRepository;
	
	@Autowired
	VegetableServiceImpl applicationService;
	  
	
	@Test
	void test(){
		 VegetableEntity items = new VegetableEntity();
		 items.setId(1);
		 items.setItems("はくさい");
		 
		 List<VegetableEntity> itemList = new ArrayList<VegetableEntity>();
		 itemList.add(items);
		 
		 when(itemRepository.findAll()).thenReturn(itemList);
		 
		 List<VegetableEntity> result  = applicationService.findAll();
		 
		VegetableEntity expectedItem =result.get(0);
		assertEquals(1,expectedItem.getId());
		assertEquals("はくさい",expectedItem.getItems());
		
	}
    
}