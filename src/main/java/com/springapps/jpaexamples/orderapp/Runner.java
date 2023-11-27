package com.springapps.jpaexamples.orderapp;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    OrderService orderService;
    @Autowired
    public Runner(OrderService orderService) {
        this.orderService = orderService;
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
