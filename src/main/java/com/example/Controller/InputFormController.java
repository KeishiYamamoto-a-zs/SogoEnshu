package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.vegetable.model.ItemList;
import com.example.form.InputForm;
import com.example.service.ApplicationServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class InputFormController {
	
	@Autowired
	private ApplicationServiceImpl applicationServiceImpl;

     
	@GetMapping("/inputForm")
	public String getInputForm(@ModelAttribute InputForm inputForm) {
		
		return "inputForm";
	}
	

	@PostMapping("/addList")
	public String postRequest(@ModelAttribute @Validated InputForm input,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
	    	return getInputForm(input);	    
		}	
		  
		String cutString = applicationServiceImpl.cut(input.getItems());
		
		ItemList itemList = new ItemList();
	    itemList.setItems(cutString);
	    itemList.setFarmer(input.getFarmer());
	    itemList.setArea(input.getArea());
		
	    applicationServiceImpl.saveItem(itemList);
	    
	    
	    log.info(cutString);
	    
	    return "redirect:/vegetable";
     }
     
	    
	
	@PostMapping("/toList")
	public String postRequest() {
	
		
		return "redirect:/vegetable";
		
	}
	
}