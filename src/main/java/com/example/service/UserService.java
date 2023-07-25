package com.example.service;

import com.example.domain.vegetable.model.UserEntity;

public interface UserService {
	public void saveUserData(UserEntity userEntity);

    public UserEntity getLoginUser(String userId);
}