package com.example.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ItemList;
import com.example.service.ApplicationServiceImpl;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class VegetableController {
	
	@Autowired
	ApplicationServiceImpl applicationServiceImpl;
     
	//データベースの情報をHTMLに出力
	@GetMapping("/Vegetable")
	public String getVegetabel(Model model){
		List<ItemList> vegetables = applicationServiceImpl.findAll();
		
		model.addAttribute("items",vegetables);//キーitemsでリストvegetablesをTimeLeafに渡す
		log.info(vegetables.toString());
		
		//Vegetable.htmlに遷移
		return "Vegetable";
		
	}
	
		

	@PostMapping("/Vegetable")
	public String postRequest() {
	
		
		return "redirect:InputForm";
		
	}
		
		
		
}


