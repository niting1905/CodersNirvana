package com.example.Rest.redis.model;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Student")
public class Student implements Serializable {

    public Student(String id, String name, Gender gender, int grade) {

        this.id = id;
        this.name = name;
        this.gender = gender;
        this.grade = grade;
    }

    public enum Gender {
        MALE, FEMALE
    }

    public String id;
    public String name;
    public Gender gender;
    public int grade;
    // ...
}