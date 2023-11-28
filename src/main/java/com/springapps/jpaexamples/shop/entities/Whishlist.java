package com.springapps.jpaexamples.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Whishlist {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;


    @OneToMany(mappedBy="wishlist", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonManagedReference("whishlistitem-wishlist")
    private List<WishlistItem> wishlistItems;


    @OneToOne
            @JsonBackReference("user-whishlist")
    @JoinColumn(name = "user_id")
    private User  user;

    public Whishlist() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<WishlistItem> getWishlistItems() {
        return wishlistItems;
    }

    public void setWishlistItems(List<WishlistItem> wishlistItems) {
        this.wishlistItems = wishlistItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
