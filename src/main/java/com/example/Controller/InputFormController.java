package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.vegetable.model.VegetableEntity;
import com.example.form.InputForm;
import com.example.service.ChangeStringServiceImpl;
import com.example.service.VegetableServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class InputFormController {
	
	@Autowired
	private VegetableServiceImpl vegetableServiceImpl;
	
	@Autowired
	ChangeStringServiceImpl changeStringServiceImpl;

     
	@GetMapping("/inputForm")
	public String getInputForm(@ModelAttribute InputForm inputForm) {
		
		return "inputForm";
	}
	

	@PostMapping("/addList")
	public String postRequest(@ModelAttribute @Validated InputForm input,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
	    	return getInputForm(input);	    
		}	
		  
		String cutString = changeStringServiceImpl.cut(input.getItems());
		
		VegetableEntity vegetableEntity = vegetableServiceImpl.copyToEntity(cutString, input);
		
	    vegetableServiceImpl.saveItem(vegetableEntity);
	    
	    
	    log.info(cutString);
	    
	    return "redirect:/vegetable";
     }
     
	    
	
	@PostMapping("/toList")
	public String postRequest() {
	
		
		return "redirect:/vegetable";
		
	}
	
}