package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.vegetable.model.ItemList;
import com.example.form.InputForm;
import com.example.service.ApplicationServiceImpl;



@Controller
public class DetailVegetableController {
	
	@Autowired
	ApplicationServiceImpl applicationServiceImpl;
	
      @GetMapping("/detailVegetable/{id}")
      public String getDetailVegetable(@PathVariable("id") int itemId, Model model,@ModelAttribute InputForm updateForm) {
    	  
    	  ItemList vegetables = applicationServiceImpl.getVegetableId(itemId);
    	  
    	  //Idをセット
    	  updateForm.setId(itemId);
    	     	  
    	  model.addAttribute("key", vegetables);
    	 
    	  return "detailVegetable";
    	  
      }
      
      @PostMapping("/updateList")
  	public String updateList(@ModelAttribute InputForm updateForm,BindingResult bindingResult) {
    	  		  
  		String cutString = applicationServiceImpl.cut(updateForm.getItems());
  		
  		ItemList itemList = new ItemList();
  		itemList.setId(updateForm.getId());
	    itemList.setItems(cutString);
	    itemList.setFarmer(updateForm.getFarmer());
	    itemList.setArea(updateForm.getArea());
  		
  	    applicationServiceImpl.updateItem(itemList);
  	    
  	    
  	    return "redirect:/vegetable";
      }
      
      @PostMapping("/delete")
  	  public String deleteItems(@RequestParam("Iddayo") int itemId) {
  	 	 
  		applicationServiceImpl.deleteItem(itemId);
  		
  		return "redirect:vegetable";	
  	}
      
      @PostMapping("/ToList")
      public String toList() {
    	  
    	  return "redirect:vegetable";
      }
}
     
      
      
