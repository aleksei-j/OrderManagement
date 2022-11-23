package com.alekseij.OrderManagement.model;

import javax.persistence.*;

@Entity
@Table
public class OrderItem {

    @Id
    @SequenceGenerator(
            name = "orderItems_sequence",
            sequenceName = "orderItems_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orderItems_sequence"
    )
    private long orderItemId;
    private long orderId;
    private long itemQuantity;

    public OrderItem() {
    }

    public OrderItem(long orderId, long itemQuantity) {
        this.orderId = orderId;
        this.itemQuantity = itemQuantity;
    }

    public long getOrderItemId() {
        return orderItemId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(long itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
