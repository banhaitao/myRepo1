package com.example.myspringboot.sytemrunner;

import com.example.myspringboot.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order
/**
 * 系统任务
 */
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public void run(String... args) throws Exception {
        //加载数据到缓存
      /*  Student student=new Student();
        student.setId(111111);
        student.setStuname("testRunner");
        student.setSex("xxx");

        redisTemplate.opsForValue().set("testRunner",student);
        log.info("Runner :"+"加载testRunner 的redis缓存");*/
    }
}
