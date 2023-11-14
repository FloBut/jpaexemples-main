package com.springapps.jpaexamples.orderapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

     List<Order> findAllByProductType (String productType);

     List<Order> findAllByOrderDateBetweenOrderByProductType(LocalDate start, LocalDate end);

     List<Order> findAllByOrderStatusIn(List<Status> orderStatusList);


}
