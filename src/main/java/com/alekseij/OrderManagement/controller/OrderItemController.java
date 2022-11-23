package com.alekseij.OrderManagement.controller;

import com.alekseij.OrderManagement.model.OrderItem;
import com.alekseij.OrderManagement.model.Product;
import com.alekseij.OrderManagement.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "orderItems")
public class OrderItemController {

    private final OrderItemService orderItemsService;

    @Autowired
    public OrderItemController (OrderItemService orderItemsService) {
        this.orderItemsService = orderItemsService;
    }

    @GetMapping(path = "{orderItemId}")
    public OrderItem getOrderItemById(@PathVariable ("orderItemId") Long orderItemId) {
        return orderItemsService.orderItemById(orderItemId);
    }

    @GetMapping(path = "{orderId}")
    public List<OrderItem> getOrderItemsByOrderId(@PathVariable ("orderId") Long orderId) {
        return orderItemsService.orderItemsByOrderId(orderId);
    }

    @GetMapping
    public List<OrderItem> getOrderItems() {
        return orderItemsService.getOrderItems();
    }



}

















