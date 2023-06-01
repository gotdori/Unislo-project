package com.miniproject.unislo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.unislo.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
