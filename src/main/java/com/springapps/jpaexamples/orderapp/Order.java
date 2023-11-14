package com.springapps.jpaexamples.orderapp;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private Status orderStatus;

    @Transient
    private String orderProgress;

    public Order(){}

    public Order(String productType, LocalDate orderDate, Status orderStatus) {
        this.productType = productType;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderProgress() {
        return orderProgress;
    }

    public void setOrderProgress(String orderProgress) {
        this.orderProgress = orderProgress;
    }

    //getters and setters


    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", productType='" + productType + '\'' +
                ", orderDate=" + orderDate +
                ", orderStatus=" + orderStatus +
                ", orderProgress='" + orderProgress + '\'' +
                '}';
    }
}


