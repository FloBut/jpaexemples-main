package com.springapps.jpaexamples.shop.repositories;

import com.springapps.jpaexamples.shop.entities.Product;
import com.springapps.jpaexamples.shop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
