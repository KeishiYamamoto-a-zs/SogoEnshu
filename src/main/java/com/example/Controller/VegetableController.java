package com.example.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ItemList;
import com.example.repository.ItemRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class VegetableController {
	
	@Autowired
	private ItemRepository itemrepository;

	@GetMapping("/Vegetable")
	public String getVegetabel(Model model){
		List<ItemList>vegetables = itemrepository.findAll() ;
		model.addAttribute("items",vegetables);//キーitemsでリストvegetablesをTimeLeafに渡す
		
		log.info(vegetables.toString());
		
		//Vegetable.htmlに遷移
		return "Vegetable";
		
	}
		
	@PostMapping("/Vegetable")
	public String postRequest(@RequestParam("text1")String str, Model model) {
		ItemList item = new ItemList();
	    item.setName(str);
	    itemrepository.save(item);
		
		model.addAttribute("input", str);
		
		
		
		log.info(str);

		return "redirect:/Vegetable";
	}
		
		
}


