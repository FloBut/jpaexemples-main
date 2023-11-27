package com.springapps.jpaexamples.manytomanydemo.v2;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private long id;
     @Column
    private String name;
     @OneToMany(mappedBy = "course")
    private  Set<CourseRegistration> courseRegistrations;
    public Course() {
    }
}
