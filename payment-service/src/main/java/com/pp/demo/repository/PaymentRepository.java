package com.pp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pp.demo.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
