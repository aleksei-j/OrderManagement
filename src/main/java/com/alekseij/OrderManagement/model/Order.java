package com.alekseij.OrderManagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private long orderId;
    private String products;
    private long quantity;
    private long registrationCode;

    public Order() {
    }

    public Order(String products, long quantity, long registrationCode) {
        this.products = products;
        this.quantity = quantity;
        this.registrationCode = registrationCode;
    }

    public long getOrderId() {
        return orderId;
    }

    public String getProducts() { return products; }

    public void setProducts(String products) {this.products = products; }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(long registrationCode) {
        this.registrationCode = registrationCode;
    }
}
