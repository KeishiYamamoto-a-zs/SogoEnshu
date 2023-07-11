package com.example.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ItemList;
import com.example.service.ApplicationServiceImpl;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class VegetableController {
	
	@Autowired
	ApplicationServiceImpl applicationServiceImpl;
     
	//データベースの情報をHTMLに出力
	@GetMapping("/vegetable")
	public String getVegetable(Model model){
		List<ItemList> vegetables = applicationServiceImpl.findAll();
		
		model.addAttribute("key",vegetables);//キーitemsでリストvegetablesをTimeLeafに渡す
		log.info(vegetables.toString());
		
		//Vegetable.htmlに遷移
		return "vegetable";
		
	}
	
	@PostMapping("/detailVegetable")
	public String selectVegetable() {
	
		
		return "redirect:detailVegetable";
		
	}
	
	@PostMapping("/delete")
	public String deleteItems(@RequestParam("Iddayo") int itemId) {
		 
		applicationServiceImpl.deleteItem(itemId);
		
		return "redirect:vegetable";	
	}
	
	
	@PostMapping("toInputForm")
	public String postRequest() {
	
		
		return "redirect:inputForm";
		
	}
	
}	
		
		


