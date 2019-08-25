package com.ouyang.lesson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ouyang.lesson.dao")
public class LessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(LessionApplication.class, args);
    }

}
