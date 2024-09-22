package com.pp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pp.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
