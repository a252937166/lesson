package com.ouyang.lesson.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Aspect
@Component
@Slf4j
public class LogAop {

    @Pointcut("execution(* com.ouyang.lesson.controller.*Controller.*(..))")
    public void pointcut() {
    }


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            //获取入参
            Object[] args = joinPoint.getArgs();
            StringBuilder arg = new StringBuilder();
            for (Object o : args) {
                arg.append(o.toString()).append(";");
            }
            log.info("{}方法入参：{}",joinPoint.toShortString(),arg.toString());
            Object proceed = joinPoint.proceed();
            log.info("{}方法返回：{}",joinPoint.toShortString(),proceed);
            return proceed;
        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
//            return new MyResponse<>(ResponseEnum.FAIL);
        }
    }
}