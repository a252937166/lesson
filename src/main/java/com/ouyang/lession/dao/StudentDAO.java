package com.ouyang.lession.dao;

import com.ouyang.lession.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * StudentDAO继承基类
 * @author ouyang
 */
@Repository
@Slf4j
public class StudentDAO {
    public Student test() {
        log.info("进入dao层了");
        Student student = new Student();
        student.setId(1);
        student.setAge(12);
        student.setGender(true);
        student.setName("测试");
        log.info("dao层执行完毕");
        return student;
    }
}