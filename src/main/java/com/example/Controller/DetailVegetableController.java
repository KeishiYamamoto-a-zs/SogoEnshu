package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Entity.VegetableEntity;
import com.example.form.InputForm;
import com.example.service.ChangeStringServiceImpl;
import com.example.service.VegetableServiceImpl;



@Controller
public class DetailVegetableController {
	
	@Autowired
	VegetableServiceImpl vegetableServiceImpl;
	
	@Autowired
	ChangeStringServiceImpl changeStringServiceImpl;
	
      @GetMapping("/detailVegetable/{id}")
      public String getDetailVegetable(@PathVariable("id") int itemId, Model model,@ModelAttribute InputForm updateForm) {
    	  
    	  VegetableEntity vegetables = vegetableServiceImpl.getVegetableById(itemId);
    	  
    	  //updateForm.setId(itemId);
    	     	  
    	  model.addAttribute("key", vegetables);
    	 
    	  return "detailVegetable";
    	  
      }
      
      @PostMapping("/updateList")
  	public String updateList(@ModelAttribute @Validated InputForm inputForm,BindingResult bindingResult,Model model) {
    	  
    	if(bindingResult.hasErrors()) {
  	    	return getDetailVegetable(inputForm.getId(),model,inputForm);	    
  		}	
    	  		  
  		String cutString = changeStringServiceImpl.cut(inputForm.getItems());
  		
  		VegetableEntity vegetableEntity = vegetableServiceImpl.copyToEntity(cutString, inputForm);
  		
	    vegetableServiceImpl.updateItem(vegetableEntity);
  	    
  	    
  	    return "redirect:/vegetable";
       }
      
      @PostMapping("/delete")
  	  public String deleteItems(@RequestParam("Iddayo") int itemId) {
  	 	 
    	vegetableServiceImpl.deleteItem(itemId);
  		
  		return "redirect:vegetable";	
  	   }
      
      @PostMapping("/ToList")
      public String toList() {
    	  
    	  return "redirect:vegetable";
      }
}
     
      
      
