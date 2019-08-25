package com.ouyang.lession.service.impl;

import com.ouyang.lession.dao.StudentDAO;
import com.ouyang.lession.model.Student;
import com.ouyang.lession.service.StudentService;
import com.ouyang.lession.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author ouyangduning
 * @date 2019/8/25 17:22
 */
@Service
@Slf4j
@Repository
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public StudentVO test() {
        log.info("进入service层了");
        Student student = studentDAO.test();
        StudentVO vo = new StudentVO();
        BeanUtils.copyProperties(student,vo);
        vo.setGender(student.getGender() ? "男" : "女");
        log.info("service层执行完毕");
        return vo;
    }
}
