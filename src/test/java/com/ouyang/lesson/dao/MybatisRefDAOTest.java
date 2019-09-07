package com.ouyang.lesson.dao;

import com.ouyang.lesson.LessionApplicationTests;
import com.ouyang.lesson.model.MybatisRef;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author ouyangduning
 * @date 2019/9/7 21:26
 */
public class MybatisRefDAOTest extends LessionApplicationTests {

    @Autowired
    private MybatisRefDAO mybatisRefDAO;

    @Test
    public void selectById() {
        MybatisRef mybatisRef = mybatisRefDAO.selectById(1);
        Assert.assertNotNull(mybatisRef);
        System.out.println(mybatisRef);
    }

    @Test
    public void selectByPrimaryKey() {
        MybatisRef mybatisRef = mybatisRefDAO.selectByPrimaryKey(1);
        Assert.assertNotNull(mybatisRef);
        System.out.println(mybatisRef);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        MybatisRef ref = new MybatisRef();
        ref.setId(1);
        ref.setBooleanCol(false);
        ref.setDateCol(new Date());
        int result = mybatisRefDAO.updateByPrimaryKeySelective(ref);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void selectList() {
        List<Integer> ids = Arrays.asList(1,2,3,4,5);
        List<MybatisRef> list = mybatisRefDAO.selectList(ids);
        Assert.assertNotNull(list);
        for (MybatisRef ref : list) {
            System.out.println(ref);
        }
    }
}