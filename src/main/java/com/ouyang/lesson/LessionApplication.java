package com.ouyang.lesson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.ouyang.lesson.dao")
@EnableTransactionManagement
public class LessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(LessionApplication.class, args);
    }

}
