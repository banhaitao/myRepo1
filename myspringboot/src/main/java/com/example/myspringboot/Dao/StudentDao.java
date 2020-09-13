package com.example.myspringboot.Dao;

import com.example.myspringboot.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> getStudent(){
        return jdbcTemplate.query("select * from Student", new BeanPropertyRowMapper<>(Student.class));
    }

}
