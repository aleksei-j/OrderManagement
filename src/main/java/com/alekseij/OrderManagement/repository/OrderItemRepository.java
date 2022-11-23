package com.alekseij.OrderManagement.repository;

import com.alekseij.OrderManagement.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
