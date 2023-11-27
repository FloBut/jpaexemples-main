package com.springapps.jpaexamples.twitterapp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TweeterService {
    TweetRepository tweetRepository;
    CommentRepository commentRepository;

    public TweeterService(TweetRepository tweetRepository, CommentRepository commentRepository) {
        this.tweetRepository = tweetRepository;
        this.commentRepository = commentRepository;
    }
@Transactional
    public Comment addCommentToTweet(Long tweet_Id, Comment comment) throws Exception {
        Tweet tweet = tweetRepository.findById(tweet_Id).orElseThrow(() -> new Exception("tweet not found"));
        comment.setTweet(tweet);
        commentRepository.save(comment);
        return comment;
    }
    @Transactional
    public Tweet addCommentToTweet2(Long tweet_Id, Comment comment) throws Exception {
        Tweet tweet = tweetRepository.findById(tweet_Id).orElseThrow(() -> new Exception("tweet not found"));
        comment.setTweet(tweet);
        tweet.getComments().add(comment);
        return tweetRepository.save(tweet);
    }
    @Transactional
    public Tweet findByText(String text) {
        return tweetRepository.findTweetByText(text);

    }
}
