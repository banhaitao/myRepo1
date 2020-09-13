package com.example.myspringboot.service;

import com.example.myspringboot.Dao.StudentDao;
import com.example.myspringboot.bean.Student;
import com.example.myspringboot.bean.requestBody;
import com.example.myspringboot.bean.responeBody;
import com.example.myspringboot.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class studentService {
    public static  final String STU_KEY="stukey";
    @Autowired
    StudentDao studentDao;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    RedisTemplate redisTemplate;
    public List<Student> getStudent(){
        return studentDao.getStudent();
    }
    public List<Student> getAllStudent(){

        List<Student> reslist=new ArrayList<>();

        //判断是否有key对应的值，返回true 或false
        if(redisTemplate.hasKey(STU_KEY)){
            List<Student> list = (List<Student>) redisTemplate.opsForValue().get(STU_KEY);
            reslist.addAll(list);
        }else{
            List<Student> studentList=studentMapper.getAllStudent();
            if(studentList.size()>0){
                //设置当前的key以及value值并且设置过期时间
                redisTemplate.opsForValue().set(STU_KEY,studentList,5, TimeUnit.MINUTES);
            }
            reslist.addAll(studentList);
        }

        return reslist;
    }


    public Student getStudentById(Integer id){
    //先从redis缓存查找数据
        Student sturedis= (Student) redisTemplate.opsForValue().get(id);
        if(sturedis!=null){
            log.info("从redis获取到数据");
            return  sturedis;
        }else{
            Student stucache=getchCache(id);
            if(stucache !=null){
                log.info("从cache获取到数据");
                redisTemplate.opsForValue().set(id,stucache);
                sturedis=stucache;
            }
        }
        return sturedis;
    }
    @Cacheable(value = "students")
    public  Student getchCache(Integer id){
        log.info("调用了缓存方法");
        return studentMapper.getStudentById(id);
    }

    public Student getStudentByRunner(){
        if(redisTemplate.hasKey("testRunner")){

            Student stu= (Student) redisTemplate.opsForValue().get("testRunner");
            return stu;
        }else{

            return null;
        }

    }

    public responeBody getRespone(requestBody req){

        responeBody res=new responeBody();

        res.setResultMessage("请求sucess");
        res.setRsponCode("200");
        Student student=new Student();
        student.setId(req.getRequestid());
        student.setStuname("reqName");
        student.setScore(100);
        List<Student> dataList=new ArrayList<Student>();
        dataList.add(student);
       for(Student s:req.getReqList()){
           dataList.add(s);
       }


        res.setDataList(dataList);
        res.setDateTime(new Date());

        return res;
    }
}
