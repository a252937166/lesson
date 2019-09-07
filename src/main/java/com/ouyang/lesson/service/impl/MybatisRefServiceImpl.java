package com.ouyang.lesson.service.impl;

import com.ouyang.lesson.dao.MybatisRefDAO;
import com.ouyang.lesson.model.MybatisRef;
import com.ouyang.lesson.service.MybatisRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ouyangduning
 * @date 2019/9/7 21:14
 */
@Service
public class MybatisRefServiceImpl implements MybatisRefService {

    @Autowired
    private MybatisRefDAO mybatisRefDAO;

    @Override
    public MybatisRef selectWithTypeReturn(Integer id) {
        return null;
    }

    @Override
    public MybatisRef findById(Integer id) {
        return mybatisRefDAO.selectByPrimaryKey(id);
    }
}
