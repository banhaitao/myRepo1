package com.example.myspringboot.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class responeBody  implements Serializable {
    private String resultMessage;
    private  String rsponCode;

    private List<Student> dataList;
   @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateTime;
}
