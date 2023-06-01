package com.miniproject.unislo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.unislo.entity.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
    UserEntity findByUserId(String userId);
}
