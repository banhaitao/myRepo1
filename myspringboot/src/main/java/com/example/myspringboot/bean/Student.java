package com.example.myspringboot.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    //
    private Integer id;
    private Integer sno;
    private String stuname;
    private String sex;
    private  Integer cno;
    private Integer score;
}
