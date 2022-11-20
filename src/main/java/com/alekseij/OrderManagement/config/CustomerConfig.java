package com.alekseij.OrderManagement.config;

import com.alekseij.OrderManagement.model.Customer;
import com.alekseij.OrderManagement.service.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(CustomerRepository repository) {
//        return args -> {
//            Customer first = new Customer(
//                    "John Smith",
//                    "john@fame.com",
//                    "+440555805452"
//            );
//            repository.saveAll(List.of(first));
//        };
//    }
}
