package com.springapps.jpaexamples.twitterapp;

import com.springapps.jpaexamples.orderapp.Order;
import com.springapps.jpaexamples.orderapp.OrderRepository;
import com.springapps.jpaexamples.orderapp.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {

    UserService userService;
    TweeterService tweeterService;

    @Autowired
    public Runner(UserService userService, TweeterService tweeterService, TweeterService tweeterService1) {

        this.userService = userService;
        this.tweeterService = tweeterService;
        this.tweeterService = tweeterService1;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Costel");
        userService.saveUser(user);

        Tweet tweet = new Tweet("bitcoin is up");
        userService.addTweetToUser2(1l, tweet);

        Tweet foundTweet = tweeterService.findByText("bitcoin is up");
        Comment comment = new Comment("uass ss");
        tweeterService.addCommentToTweet(foundTweet.getId(),  comment);
        userService.addTweetToUser1(1L,tweet);
        userService.deleteAllTweetsFromUser(1L);
        //userService.deleteAllTweetsFromUser2(1L);
        //userService.deleteUser(1L);


    }
}
