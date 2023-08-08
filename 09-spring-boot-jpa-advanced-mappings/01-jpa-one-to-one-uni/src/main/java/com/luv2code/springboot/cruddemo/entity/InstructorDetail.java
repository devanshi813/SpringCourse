package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.lang.annotation.Target;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

    // annotate the class as an entity and map to db table

    // define the fields

    // annotate the fields with db column names

    // create constructors

    // generate getter/setter methods

    // generate toString() method

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="youtube_channel")
    private String youtubechannel;

    @Column(name="hobby")
    private String hobby;

    public InstructorDetail(){

    }
    public InstructorDetail(String youtubechannel, String hobby) {
        this.youtubechannel = youtubechannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubechannel() {
        return youtubechannel;
    }

    public void setYoutubechannel(String youtubechannel) {
        this.youtubechannel = youtubechannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubechannel='" + youtubechannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
