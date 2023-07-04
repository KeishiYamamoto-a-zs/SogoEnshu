package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ItemList;
import com.example.form.InputForm;
import com.example.service.ApplicationServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class InputFormController {
	
	@Autowired
	private ApplicationServiceImpl applicationServiceImpl;

     
	@GetMapping("/InputForm")
	public String getInputForm(@ModelAttribute InputForm form ) {
		
		return "InputForm";
	}
	

	@PostMapping("/addList")
	public String postRequest(@ModelAttribute @Validated InputForm items,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
	    	return getInputForm(items);	    
		}
		
		ItemList itemList = new ItemList();
		itemList.setItems(items.getItems());
		
		String cutString = applicationServiceImpl.cut(itemList.getItems());	
		  
	    applicationServiceImpl.saveItem(cutString);    
	    
	    
	    log.info(cutString);
	    
	    return "redirect:/Vegetable";
     }
     
	    
	
	@PostMapping("/ToList")
	public String postRequest() {
	
		
		return "redirect:/Vegetable";
		
	}
	
}