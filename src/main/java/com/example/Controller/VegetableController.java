package com.example.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ItemList;
import com.example.repository.ItemRepository;


@Controller
public class VegetableController {
	
	@Autowired
	private ItemRepository itemrepository;

	@GetMapping("/Vegetable")
	public String getVegetabel(Model model){
		List<ItemList>vegetables = itemrepository.findAll() ;
		model.addAttribute("items",vegetables);//キーitemsでリストvegetableをTimeLeafに渡す
		
		//Vegetable.htmlに遷移
		return "Vegetable";
	}

}
