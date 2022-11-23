package com.alekseij.OrderManagement.config;

import com.alekseij.OrderManagement.model.Customer;
import com.alekseij.OrderManagement.model.Product;
import com.alekseij.OrderManagement.repository.CustomerRepository;
import com.alekseij.OrderManagement.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository, ProductRepository productRepository) {
        return args -> {
            Customer first = new Customer(
                    "John Smith",
                    "john@fame.com",
                    "+440555805452"
            );
            customerRepository.saveAll(List.of(first));

            Product product = new Product(
                    "Black T-shirt",
                    "TSH-000-L",
                    1999L
            );
            productRepository.saveAll(List.of(product));
        };
    }
}
