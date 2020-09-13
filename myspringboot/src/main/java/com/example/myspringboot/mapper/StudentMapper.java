package com.example.myspringboot.mapper;

import com.example.myspringboot.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<Student> getAllStudent();

    Student getStudentById(Integer id);
}
