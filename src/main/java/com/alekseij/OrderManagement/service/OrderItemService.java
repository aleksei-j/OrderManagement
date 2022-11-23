package com.alekseij.OrderManagement.service;

import com.alekseij.OrderManagement.model.OrderItem;
import com.alekseij.OrderManagement.repository.OrderItemRepository;

import java.util.List;

public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem orderItemById(long orderItemId) {
        return orderItemRepository.findById(orderItemId).orElseThrow(() ->
                new IllegalStateException("OrderItems with orderItemId: " + orderItemId + " does not exist"));
    }

    /*
    check if it works
     */
    public List<OrderItem> orderItemsByOrderId(long orderId) {
        return orderItemRepository.findById(orderId).stream().toList();
    }

    public List<OrderItem> getOrderItems() {
        return orderItemRepository.findAll();
    }

    public void postNewOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(long orderItemId) {
        boolean exists = orderItemRepository.existsById(orderItemId);

        if(!exists) {
            throw new IllegalStateException("OrderItems with orderItemId: " + orderItemId + " does not exist");
        }

        orderItemRepository.deleteById(orderItemId);
    }
}
