package com.alekseij.OrderManagement.service;


import com.alekseij.OrderManagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
