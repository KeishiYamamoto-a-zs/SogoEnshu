package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.vegetable.model.UserEntity;
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

	

}
