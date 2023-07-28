package com.example.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.vegetable.model.VegetableEntity;
import com.example.service.VegetableServiceImpl;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class VegetableController {
	
	@Autowired
	VegetableServiceImpl vegetableServiceImpl;
     
	//データベースの情報をHTMLに出力
	@GetMapping("/vegetable")
	public String getVegetable(Model model){
		List<VegetableEntity> vegetables = vegetableServiceImpl.findAll();
		
		model.addAttribute("key",vegetables);//キーitemsでリストvegetablesをTimeLeafに渡す
		log.info(vegetables.toString());
		
		//Vegetable.htmlに遷移
		return "vegetable";
		
	}
		
	@PostMapping("/toInputForm")
	public String postRequest() {
		
		return "redirect:inputForm";		
	}
	
}	