package com.miniproject.unislo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.unislo.entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

}
