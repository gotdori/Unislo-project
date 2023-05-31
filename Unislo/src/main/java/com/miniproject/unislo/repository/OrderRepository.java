package com.miniproject.unislo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.unislo.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
