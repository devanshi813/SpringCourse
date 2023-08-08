package com.luv2code.springboot.cruddemo.entity;


import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name="review")
public class Review {

    // define fields

    // define constructors

    // define getters/setters

    // define to string

    // annotate fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="comment")
    private String comment;

    private Review(){

    }

    public Review(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String
    toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
