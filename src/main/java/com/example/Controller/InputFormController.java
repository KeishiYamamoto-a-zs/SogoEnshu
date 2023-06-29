package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ItemList;
import com.example.repository.ItemRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class InputFormController {
	
	@Autowired
	private ItemRepository itemrepository;

     
	@GetMapping("/InputForm")
	public String getInputForm(Model model, @ModelAttribute ItemList itemList) {
		
		return "InputForm";
	}

	@PostMapping("/add")
	public String postRequest(@ModelAttribute @Validated ItemList itemList,BindingResult bindingResult, Model model) {
	    String str = itemList.getItems();
	    
	    String truncatedStr = str.substring(0, str.length() - 1);
	    
	    if(bindingResult.hasErrors()) {
		    
		     return getInputForm(model,itemList);	    
		}
	        
	    
	    ItemList item = new ItemList();
	    item.setItems(truncatedStr); // itemListからitemsの値を取得し、新しいItemListオブジェクトに設定する
	    itemrepository.save(item);
	    
	    model.addAttribute("input",truncatedStr);
	    	 
        
	    log.info(str);
	    
	    return "redirect:/Vegetable";
	    
	    
	}
	
	@PostMapping("/ToList")
	public String postRequest() {
	
		
		return "redirect:/Vegetable";
		
	}
	
}