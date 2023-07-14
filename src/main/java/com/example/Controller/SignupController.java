package com.example.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class SignupController {
	
	@GetMapping("/signup")
	public String getSignup() {
		
		
		return "/signup";		
	}
	
	

}
