package com.example.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class VegetableController {
	
	@GetMapping("/Vegetable")
	public String getVegetabel(){
		//Vegetable.htmlに遷移
		return "Vegetable";
	}

}
