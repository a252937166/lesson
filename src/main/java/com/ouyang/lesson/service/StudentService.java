package com.ouyang.lesson.service;

import com.github.pagehelper.PageInfo;
import com.ouyang.lesson.model.Student;
import com.ouyang.lesson.vo.StudentVO;

import java.util.List;

/**
 * @author ouyangduning
 * @date 2019/8/25 17:21
 */
public interface StudentService {
    /**
     * 查找所有学生
     * @return
     */
    List<StudentVO> findAll();

    /**
     * 查找学生
     * @param id 学生id
     * @return
     */
    StudentVO findById(Integer id);

    /**
     * 分页查找
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Student> getPage(Integer pageNo, Integer pageSize);

    /**
     * 新增
     * @param student
     * @return
     */
    Integer insert(Student student);
}
