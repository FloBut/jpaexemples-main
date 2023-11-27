package com.springapps.jpaexamples.orderapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Order findById(Long id)  {
        return orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("order not found"));
    }
    public List<Order> findAll() {

        return orderRepository.findAll();
    }
    public List<Order> findOrderByLocalDateBetween (LocalDate start, LocalDate end) {
       return orderRepository.findAllByOrderDateBetweenOrderByProductType( start, end).orElseThrow(()-> new ResourceNotFoundException("no order founded between dates"));
    }
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public Order updateOrder(Order order, Long id)  {
        Order orderToBeUpdated = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("order not found"));
        orderToBeUpdated.setOrderStatus(order.getOrderStatus());
        orderToBeUpdated.setOrderDate(order.getOrderDate());
        orderToBeUpdated.setProductType(order.getProductType());
        return orderRepository.save(orderToBeUpdated);

//        order.setOrderId(id);
//        return orderRepository.save(order);
    }
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

}
