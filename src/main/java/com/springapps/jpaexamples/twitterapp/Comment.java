package com.springapps.jpaexamples.twitterapp;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name="tweet_id")
    private Tweet tweet;

    public Comment(String text) {

        this.text = text;

    }

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", tweet=" + tweet +
                '}';
    }
}
