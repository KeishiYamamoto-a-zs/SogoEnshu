package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    
	public Optional<UserEntity> findByMailaddress (String userMailAddress);
}
