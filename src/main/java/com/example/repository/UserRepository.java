package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.vegetable.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
