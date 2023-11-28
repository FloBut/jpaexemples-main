package com.springapps.jpaexamples.shop.controllers;

import com.springapps.jpaexamples.shop.dtos.WishlistRequestDTO;
import com.springapps.jpaexamples.shop.entities.Whishlist;
import com.springapps.jpaexamples.shop.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishlist")

public class WishlistController {

    private WishListService wishListService;

    @Autowired
    public WishlistController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @PostMapping
    public ResponseEntity<Whishlist> addToWishList(@RequestBody WishlistRequestDTO wishlistRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(wishListService.addItemToWishlist(wishlistRequestDTO));
    }
}

