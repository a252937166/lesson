package com.ouyang.lesson.controller;

import com.github.pagehelper.PageInfo;
import com.ouyang.lesson.model.Student;
import com.ouyang.lesson.service.StudentService;
import com.ouyang.lesson.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ouyangduning
 * @date 2019/8/25 17:17
 */
@RestController
@Slf4j
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/get")
    public StudentVO get(@Param("id") Integer id) {
        StudentVO vo = studentService.findById(id);
        return vo;
    }

    @RequestMapping("/getList")
    public List<StudentVO> getList() {
        List<StudentVO> list = studentService.findAll();
        return list;
    }

    @RequestMapping("/getPage")
    public PageInfo<Student> getPage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        return studentService.getPage(pageNo,pageSize);
    }

    @PostMapping("/insert")
    public Integer getPage(@RequestBody Student student) {
        return studentService.insert(student);
    }
}
