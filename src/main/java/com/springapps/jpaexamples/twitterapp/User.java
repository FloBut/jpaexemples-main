package com.springapps.jpaexamples.twitterapp;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    // inverse side of the relational cheia primara a user - ului se gaseste
    // in tweet

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;
//cascadeaza si la tweet ul userlui, practic la copiii user ului se va propaga update user
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
    //mapped indica numele obiectului cu care se va face legatura
    // cascade = Cascade.Type.All -> tot ce se face pe clasa parinte se va cascada si la clasa copiilor
    //
    private List<Tweet> tweets;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tweets=" + tweets +
                '}';
    }
}
