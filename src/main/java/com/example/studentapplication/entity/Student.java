package com.example.studentapplication.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer sno;
    private  String  stdName;
    private  String  stdClass;
    private  String  schoolName;
    private  String  schoolAddress;


}
