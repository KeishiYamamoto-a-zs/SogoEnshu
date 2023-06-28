package com.example.Controller;

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
public class InputFormController {
	
	@Autowired
	private ItemRepository itemrepository;

     
	@GetMapping("/InputForm")
	public String getInputForm() {
		
		return "InputForm";
	}

	@PostMapping("/add")
	public String postRequest(@RequestParam("text1")String str, Model model) {
		ItemList item = new ItemList();
	    item.setName(str);
	    itemrepository.save(item);
		
		model.addAttribute("input", str);
		
				log.info(str);

		return "redirect:/Vegetable";
	}
	
	@PostMapping("/ToList")
	public String postRequest() {
	
		
		return "redirect:/Vegetable";
		
	}
	
}
