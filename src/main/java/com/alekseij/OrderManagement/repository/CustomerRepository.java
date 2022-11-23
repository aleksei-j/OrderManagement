package com.alekseij.OrderManagement.repository;

import com.alekseij.OrderManagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
