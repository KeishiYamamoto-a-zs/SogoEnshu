package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Entity.UserEntity;
import com.example.form.SignupForm;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
    public void saveUserData(UserEntity userEntity) {
		
	   String rawPassword = userEntity.getPassword();
	   userEntity.setPassword(encoder.encode(rawPassword));
	
       userRepository.save(userEntity);
    
    }

	@Override
	public UserEntity getLoginUser(String userMailAddress) {
		Optional<UserEntity> users = userRepository.findByMailaddress(userMailAddress);
	    UserEntity user = users.orElse(null);
		return user;
	}
	
	@Override
	public UserEntity copyToEntity(SignupForm signupForm) {
        UserEntity userEntity = new UserEntity();
		
		userEntity.setPassword(signupForm.getPassword());
		userEntity.setMailaddress(signupForm.getMailaddress());
		userEntity.setAuthority(signupForm.getAuthority());
		
		return userEntity;
		
	}

	

}
