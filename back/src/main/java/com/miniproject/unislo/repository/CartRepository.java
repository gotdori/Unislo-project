package com.miniproject.unislo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.unislo.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

}
