package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.vegetable.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    
	public Optional<UserEntity> findByMailaddress (String userMailAddress);
}
