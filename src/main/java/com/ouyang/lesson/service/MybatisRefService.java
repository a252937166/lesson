package com.ouyang.lesson.service;

import com.ouyang.lesson.model.MybatisRef;

/**
 * @author ouyangduning
 * @date 2019/9/7 21:12
 */
public interface MybatisRefService {
    /**
     * 根据class类型返回
     * @param id
     * @return
     */
    MybatisRef selectWithTypeReturn(Integer id);

    MybatisRef findById(Integer id);
}
