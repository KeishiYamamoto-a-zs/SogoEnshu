package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.vegetable.model.UserEntity;
import com.example.form.SignupForm;
import com.example.service.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		
		log.info(signupForm.toString());
		
		if(bindingResult.hasErrors()) {
	    	return getSignup(signupForm);	    
		}
		
		UserEntity userEntity = new UserEntity();
		
		userEntity.setPassword(signupForm.getPassword());
		userEntity.setMailaddress(signupForm.getMailaddress());
		userEntity.setAuthority(signupForm.getAuthority());
		
	    userServiceImpl.saveUserData(userEntity);
	    
		
		return "redirect:/login";		
	}
	
	@PostMapping("/toLoginForm")
	public String toLoginForm() {
		
		return "redirect:/login";
	}
}
