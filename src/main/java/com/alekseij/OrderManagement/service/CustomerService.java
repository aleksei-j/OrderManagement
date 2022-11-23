package com.alekseij.OrderManagement.service;

import com.alekseij.OrderManagement.model.Customer;
import com.alekseij.OrderManagement.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Long registrationCode) {
        return customerRepository.findById(registrationCode).orElseThrow(() ->
                new IllegalStateException("Customer with registrationCode:" + registrationCode + " not found"));
    }

    public List<Customer> getCustomers() {return customerRepository.findAll(); }

    public void postNewCustomer(Customer customer) {customerRepository.save(customer); }

    public void deleteCustomer(Long registrationCode) {
        boolean exists = customerRepository.existsById(registrationCode);

        if (!exists) {
            throw new IllegalStateException("Customer with registrationCode: " + registrationCode + " not found");
        }

        customerRepository.deleteById(registrationCode);
    }

    @Transactional
    public void updateCustomerEmail(Long registrationCode, String email) {

        Customer customer = customerRepository.findById(registrationCode).orElseThrow(() ->
                new IllegalStateException("Customer with registrationCode:" + registrationCode + " not found"));
        customer.setEmail(email);
    }

    @Transactional
    public void updateCustomerTelephone(Long registrationCode, String telephone) {

        Customer customer = customerRepository.findById(registrationCode).orElseThrow(() ->
                new IllegalStateException("Customer with registrationCode:" + registrationCode + " not found"));
        customer.setTelephone(telephone);
    }
}
