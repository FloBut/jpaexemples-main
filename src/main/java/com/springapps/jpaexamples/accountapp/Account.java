package com.springapps.jpaexamples.accountapp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private long id;

    @Column
    private Integer balance;

    public Account(){}

    public Account(long id, Integer balance) {
        this.id = id;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long orderId) {
        this.id = orderId;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) throws Exception{
        if (balance < 0){
            throw new Exception("neg balance");
        }
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "orderId=" + id +
                ", balance=" + balance +
                '}';
    }
}
