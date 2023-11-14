package com.springapps.jpaexamples.orderapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {

    OrderRepository orderRepository;

    @Autowired
    public Runner(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Order order = new Order("tip1", LocalDate.of(2023,3,12),Status.PENDING);
        Order order2 = new Order("tip1", LocalDate.of(2023,3,14),Status.PENDING);
        orderRepository.save(order);
        orderRepository.save(order2);

        Order foundOrder = orderRepository.findById(1L).orElseThrow(()->new Exception("order not found"));
        System.out.println(foundOrder);

        foundOrder.setOrderStatus(Status.RECEIVED);
        orderRepository.save(foundOrder);

        System.out.println("tip1 "+orderRepository.findAllByProductType("tip1"));
        System.out.println("between " +orderRepository.findAllByOrderDateBetweenOrderByProductType(LocalDate.of(2023,3,11),LocalDate.of(2023,3,13)));


        orderRepository.delete(order2);
        System.out.println(orderRepository.findAll());


    }
}
