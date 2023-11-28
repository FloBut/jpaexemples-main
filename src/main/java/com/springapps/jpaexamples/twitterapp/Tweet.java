package com.springapps.jpaexamples.twitterapp;

import jakarta.persistence.*;

import java.util.List;

@Entity
//detine relatia in adica are cheia straina, aici se gasete chiea straina
public class Tweet {

    @Id
    @GeneratedValue
    private long id;


    @Column
    private String text;

    @ManyToOne// realatia dinspre user spre tweet, cheia straina din tabelul Tweet
    @JoinColumn(name = "user_id")// numele coloanei care va fi chiea straina in user
    private User user;


    @OneToMany(mappedBy="tweet", cascade = CascadeType.ALL, orphanRemoval = true)// un tweet are o lista de comentarii si se leaga
    private List<Comment> comments;

    public Tweet(String text) {
        this.text = text;
    }

    public Tweet() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", comments=" + comments +
                '}';
    }
}
