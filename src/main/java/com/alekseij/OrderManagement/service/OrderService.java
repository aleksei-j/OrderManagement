package com.alekseij.OrderManagement.service;

import com.alekseij.OrderManagement.model.Order;
import com.alekseij.OrderManagement.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() ->
                new IllegalStateException("Order with orderId:" + orderId + " not found"));
    }

    public List<Order> getOrders() {return orderRepository.findAll(); }

    public void postNewOrder(Order order) {
        orderRepository.save(order); }

    public void deleteOrder(Long orderId) {
        boolean exists = orderRepository.existsById(orderId);

        if (!exists) {
            throw new IllegalStateException("Order with orderId: " + orderId + " not found");
        }

        orderRepository.deleteById(orderId);
    }
}
