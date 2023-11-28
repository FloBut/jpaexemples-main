package com.springapps.jpaexamples.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class WishlistItem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    @JsonBackReference("whishlistitem-product")
    private Product product;

    @ManyToOne
    @JoinColumn(name="whishlist_id")
    @JsonBackReference("whishlistitem-wishlist")
    private Whishlist wishlist;

    public WishlistItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Whishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Whishlist wishlist) {
        this.wishlist = wishlist;
    }
}
