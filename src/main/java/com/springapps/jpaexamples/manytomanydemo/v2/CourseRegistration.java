package com.springapps.jpaexamples.manytomanydemo.v2;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class CourseRegistration {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn (name = "course_id")
    private Course course;

    @Column
    LocalDate registerAt;

}
