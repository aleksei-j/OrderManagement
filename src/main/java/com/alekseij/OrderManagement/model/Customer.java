package com.alekseij.OrderManagement.model;

import javax.persistence.*;

@Entity
@Table
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private long registrationCode;
    private String fullName;
    private String email;
    private String telephone;

    public Customer() {
    }

    public Customer(String email, String telephone) {
        this.email = email;
        this.telephone = telephone;
    }

    public Customer(String fullName, String email, String telephone) {
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
    }

    public long getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(long registrationCode) {
        this.registrationCode = registrationCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
