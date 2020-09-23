package com.example.myspringboot.controller;

import com.example.myspringboot.bean.Student;
import com.example.myspringboot.bean.person;
import com.example.myspringboot.bean.requestBody;
import com.example.myspringboot.bean.responeBody;
import com.example.myspringboot.service.studentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hello")
public class helloController {

    private  final Logger logger= LoggerFactory.getLogger(helloController.class);

    @Autowired
    private studentService studentservice;

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public person  method(){

        logger.info("-------------------进入method");
     person p=new person();
     p.setId(123);
     p.setName("abc");

    return  p;
    }

    @RequestMapping(value="/getStudent", method = RequestMethod.GET)
     public List<Student> getStudent(){
        //return studentservice.getStudent();
        return studentservice.getAllStudent();
    }

    @RequestMapping(value="/getStuById", method = RequestMethod.GET)
    public Student getStudentById(Integer id){
        return studentservice.getStudentById(id);
    }

    @RequestMapping(value="/getStuRunner", method = RequestMethod.GET)
    public Student getStudentByRunner(){

        return studentservice.getStudentByRunner();
    }

    @RequestMapping(value="/getRespone", method = RequestMethod.POST)
    public responeBody getRespone(@RequestBody requestBody req){
      log.info("请求参数："+req);
        return studentservice.getRespone(req);
    }

    @RequestMapping(value="/gitHub", method = RequestMethod.GET)
    public String testGitHub(){
        log.info("testgittogithub");

        return "testGithub";
    }
}
