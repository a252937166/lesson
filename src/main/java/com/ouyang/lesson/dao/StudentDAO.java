package com.ouyang.lesson.dao;

import com.ouyang.lesson.model.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * StudentDAO继承基类
 * @author Administrator
 */
public interface StudentDAO extends MyBatisBaseDao<Student, Integer> {
    @Select("select id, `name`, age, gender from student")
    List<Student> findAll();
}