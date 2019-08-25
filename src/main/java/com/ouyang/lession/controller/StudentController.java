package com.ouyang.lession.controller;

import com.ouyang.lession.service.StudentService;
import com.ouyang.lession.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/test")
    public StudentVO test() {
        log.info("进入controller层了");
        StudentVO test = studentService.test();
        log.info("controller层执行完毕");
        return test;
    }

}
