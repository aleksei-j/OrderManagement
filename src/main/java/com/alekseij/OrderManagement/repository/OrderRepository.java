package com.alekseij.OrderManagement.repository;

import com.alekseij.OrderManagement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
