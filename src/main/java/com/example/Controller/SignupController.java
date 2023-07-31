package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Entity.UserEntity;
import com.example.form.SignupForm;
import com.example.service.UserServiceImpl;

@Controller
public class SignupController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/signup")
	public String getSignup(@ModelAttribute SignupForm signupForm) {
		
		
		return "/signup";		
	}
	
	@PostMapping("/signupUser")
	public String postSignup(@ModelAttribute @Validated SignupForm signupForm,BindingResult bindingResult){

		
		if(bindingResult.hasErrors()) {
	    	return getSignup(signupForm);	    
		}
		
		UserEntity userEntity = userServiceImpl.copyToEntity(signupForm);
		
	    userServiceImpl.saveUserData(userEntity);
	    
		
		return "redirect:/login";		
	}
	
	@PostMapping("/toLoginForm")
	public String toLoginForm() {
		
		return "redirect:/login";
	}
}
