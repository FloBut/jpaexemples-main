package com.springapps.jpaexamples.twitterapp;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String text;

    @ManyToOne ()//pot fi mai multe  la un tweet
    @JoinColumn(name="tweet_id")// coloana comment va avea  mai multe tweet uri
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
