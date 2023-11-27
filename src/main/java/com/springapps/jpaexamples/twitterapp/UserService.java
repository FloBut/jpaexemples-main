package com.springapps.jpaexamples.twitterapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    TweetRepository tweetRepository;

    @Autowired
    public UserService(UserRepository userRepository, TweetRepository tweetRepository) {
        this.userRepository = userRepository;
        this.tweetRepository=tweetRepository;
    }

    public User saveUser (User user){
        return userRepository.save(user);

    }

    @Transactional
    public Tweet addTweetToUser2 (Long userId, Tweet tweet) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("user not found"));
        tweet.setUser(user);
        return tweetRepository.save(tweet);
    }

    @Transactional
    public User addTweetToUser1 (Long userId, Tweet tweet) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("user not found"));
        tweet.setUser(user);
        user.getTweets().add(tweet);
        return userRepository.save(user);
    }

    @Transactional
    public void deleteAllTweetsFromUser(Long userId) throws Exception {
       tweetRepository.deleteAllByUser_Id(userId);
    }
    @Transactional
    public void deleteAllTweetsFromUser1(Long userId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("user not found"));
//        for (Tweet tweet: user.getTweets()){
//            tweetRepository.delete(tweet);
//        }
        tweetRepository.deleteAllInBatch(user.getTweets());
    }

    @Transactional
    public User deleteAllTweetsFromUser2(Long userId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("user not found"));
        user.getTweets().clear();
        return userRepository.save(user);
    }


    public void deleteUser(Long userId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("user not found"));
        userRepository.delete(user);
    }
}
