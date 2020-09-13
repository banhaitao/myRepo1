package com.example.myspringboot.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class requestBody implements Serializable {
    @JsonProperty("requestid")
 private Integer requestid;
    @JsonProperty("flag")
    private String flag;

    @JsonProperty("reqList")
    private List<Student> reqList;



}
