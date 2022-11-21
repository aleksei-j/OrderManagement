package com.alekseij.OrderManagement.controller;

import com.alekseij.OrderManagement.model.Customer;
import com.alekseij.OrderManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) { this.customerService = customerService; }

    @GetMapping(path = "{registrationCode}")
    public Customer getCustomer(@PathVariable ("registrationCode") Long registrationCode) {
        return customerService.getCustomer(registrationCode);
    }

    @GetMapping
    public List<Customer> getCustomers() {return  customerService.getCustomers(); }

    @PostMapping
    public Long postNewCustomer(@RequestBody Customer customer) {
        customerService.postNewCustomer(customer);
        return customer.getRegistrationCode();
    }

    @DeleteMapping(path = "{registrationCode}")
    public void deleteCustomer(@PathVariable ("registrationCode") Long registrationCode) {
        customerService.deleteCustomer(registrationCode);
    }

    @PutMapping(path = "{registrationCode}")
    public void updateCustomer(@PathVariable ("registrationCode") Long registrationCode, @RequestParam(required = false) String email,
                               @RequestParam(required = false) String telephone) {
        if (telephone != null)
            customerService.updateCustomerTelephone(registrationCode, telephone);
        if (email != null)
            customerService.updateCustomerEmail(registrationCode, email);
    }

}
