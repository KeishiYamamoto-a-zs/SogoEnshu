package com.example.service;

import com.example.Entity.UserEntity;
import com.example.form.SignupForm;

public interface UserService {
	public void saveUserData(UserEntity userEntity);

    public UserEntity getLoginUser(String userId);
    
    public UserEntity copyToEntity(SignupForm signupForm);
}