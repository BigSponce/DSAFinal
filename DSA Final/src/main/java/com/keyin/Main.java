package com.keyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.keyin.customer", "com.keyin.order", "com.keyin.product", "com.keyin.orderitem"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}