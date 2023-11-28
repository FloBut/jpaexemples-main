package com.springapps.jpaexamples.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    @JsonBackReference("cartitem-product")
    private Product product;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference("cartitem-user")
    private User user;
}
