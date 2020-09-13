package com.example.myspringboot.Aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LogAspect {
    @Pointcut("execution(* com.example.myspringboot.service.*.*(..))")
    public void pc1(){
    }

    @Before(value = "pc1()")
    public  void before(JoinPoint jp){
        String name=jp.getSignature().getName();
        log.info(name +"方法开始执行");
    }

    @After(value = "pc1()")
    public  void after(JoinPoint jp){
        String name=jp.getSignature().getName();
        log.info(name +"方法执行结束");
    }
}
