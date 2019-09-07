package com.ouyang.lesson.dao;

import com.ouyang.lesson.model.MybatisRef;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MybatisRefDAO继承基类
 */
public interface MybatisRefDAO extends MyBatisBaseDao<MybatisRef, Integer> {

    /**
     * 根据id查询
     * @param id id
     * @return
     */
    MybatisRef selectById(@Param("id") Integer id);

    /**
     * 查询列表
     * @param ids id列表
     * @return
     */
    List<MybatisRef> selectList(@Param("ids") List<Integer> ids);
}