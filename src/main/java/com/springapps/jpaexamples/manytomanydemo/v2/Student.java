package com.springapps.jpaexamples.manytomanydemo.v2;

import com.springapps.jpaexamples.manytomanydemo.v2.Course;
import jakarta.persistence.*;

import java.util.Set;
@Entity
public class Student {

    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;

    @OneToMany(mappedBy = "student")

    Set<CourseRegistration> courseRegistrations;

    public Student() {
    }
}
