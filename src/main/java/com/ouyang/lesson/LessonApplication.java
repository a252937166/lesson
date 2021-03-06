package com.ouyang.lesson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.ouyang.lesson.dao")
@EnableTransactionManagement
@ServletComponentScan(basePackages = "com.ouyang.lesson.filter")
public class LessonApplication {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors","false");
        SpringApplication.run(LessonApplication.class, args);
    }

}
