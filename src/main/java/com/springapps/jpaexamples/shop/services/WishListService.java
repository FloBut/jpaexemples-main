package com.springapps.jpaexamples.shop.services;

import com.springapps.jpaexamples.shop.dtos.WishlistRequestDTO;
import com.springapps.jpaexamples.shop.entities.Product;
import com.springapps.jpaexamples.shop.entities.Whishlist;
import com.springapps.jpaexamples.shop.entities.WishlistItem;
import com.springapps.jpaexamples.shop.exceptions.ResourceNotFoundException;
import com.springapps.jpaexamples.shop.repositories.ProductRepository;
import com.springapps.jpaexamples.shop.repositories.UserRepository;
import com.springapps.jpaexamples.shop.repositories.WIshlistItemRepository;
import com.springapps.jpaexamples.shop.repositories.WishlistRepository;
import com.springapps.jpaexamples.shop.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WishListService {


    private UserRepository userRepository;
    private WIshlistItemRepository wIshlistItemRepository;

    private ProductRepository productRepository;

    private WishlistRepository wishlistRepository;

    @Autowired
    public WishListService(ProductRepository productRepository, UserRepository userRepository, WIshlistItemRepository wIshlistItemRepository, WishlistRepository wishlistRepository) {
        this.userRepository = userRepository;
        this.wIshlistItemRepository = wIshlistItemRepository;
        this.wishlistRepository = wishlistRepository;
        this.productRepository = productRepository;
    }
    @Transactional
    public Whishlist addItemToWishlist(WishlistRequestDTO wishlistRequestDTO){
        User user = userRepository.findById(wishlistRequestDTO.getUserId()).orElseThrow(()->new ResourceNotFoundException("user not found"));
        Product product = productRepository.findById(wishlistRequestDTO.getProductId()).orElseThrow(()->new ResourceNotFoundException("product not found"));
        Whishlist whishlist = user.getWishlist();
        WishlistItem wishlistItem = new WishlistItem();
        wishlistItem.setProduct(product);
        wishlistItem.setWishlist(whishlist);
        whishlist.getWishlistItems().add(wishlistItem);
        return wishlistRepository.save(whishlist);

    }
}
