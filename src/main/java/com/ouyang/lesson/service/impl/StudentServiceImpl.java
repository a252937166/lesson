package com.ouyang.lesson.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ouyang.lesson.dao.StudentDAO;
import com.ouyang.lesson.model.Student;
import com.ouyang.lesson.service.StudentService;
import com.ouyang.lesson.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<StudentVO> findAll() {
        List<Student> list = studentDAO.findAll();
        List<StudentVO> vos = new ArrayList<>();
        for (Student student : list) {
            StudentVO studentVO = new StudentVO();
            BeanUtils.copyProperties(student,studentVO);
            studentVO.setGender(student.getGender() ? "男" : "女");
            vos.add(studentVO);
        }
        return vos;
    }

    @Override
    public StudentVO findById(Integer id) {
        Student student = studentDAO.selectByPrimaryKey(id);
        StudentVO studentVO = new StudentVO();
        BeanUtils.copyProperties(student,studentVO);
        studentVO.setGender(student.getGender() ? "男" : "女");
        return studentVO;
    }

    @Override
    @Cacheable(value = "students",key = "#pageNo+'_'+#pageSize")
    public Page<StudentVO> getPage(Integer pageNo, Integer pageSize) {
        log.info("使用数据库查询");
        PageHelper.startPage(pageNo,pageSize);
        List<Student> students = studentDAO.findAll();
        Page<StudentVO>  page = new Page<>();
        for (Student u : students) {
            StudentVO vo = new StudentVO();
            BeanUtils.copyProperties(u,vo);
            vo.setGender(u.getGender() ? "男" : "女");
            page.add(vo);
        }
        //获取分页信息
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        page.setTotal(pageInfo.getTotal());
        return page;
    }


}
