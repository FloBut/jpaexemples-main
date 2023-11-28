package com.springapps.jpaexamples.shop.repositories;

import com.springapps.jpaexamples.shop.entities.Whishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Whishlist, Long> {
}
