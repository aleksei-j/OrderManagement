package com.alekseij.OrderManagement.controller;

import com.alekseij.OrderManagement.model.Order;
import com.alekseij.OrderManagement.model.Product;
import com.alekseij.OrderManagement.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "order")
public class OrderController {

    public final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "{orderId}")
    public Order getOrder (@PathVariable ("orderId") Long orderId) {
        return orderService.getOrder(orderId);
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    public Long postNewEntry(@RequestBody Order order) {
        orderService.postNewOrder(order);
        return order.getOrderId();
    }

    @DeleteMapping(path = "{orderId}")
    public void deleteOrder(@PathVariable ("orderId") Long orderId) {
        orderService.deleteOrder(orderId);
    }

    @PostMapping
    private void addProduct(long productId, Product product, long productQuantity) {

    }
}
