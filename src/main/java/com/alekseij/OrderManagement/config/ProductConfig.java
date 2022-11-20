package com.alekseij.OrderManagement.config;

import com.alekseij.OrderManagement.model.Product;
import com.alekseij.OrderManagement.service.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(ProductRepository repository) {
//        return args -> {
//            Product first = new Product(
//                "Black T-shirt", "TSH-000-L", 1999L
//            );
//            repository.saveAll(List.of(first));
//        };
//    }
}
