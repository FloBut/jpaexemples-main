package com.springapps.jpaexamples.twitterapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet,Long> {

    public void deleteAllByUser_Id(Long userId);
}
