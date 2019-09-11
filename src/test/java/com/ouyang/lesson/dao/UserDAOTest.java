package com.ouyang.lesson.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ouyang.lesson.LessionApplicationTests;
import com.ouyang.lesson.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author ouyangduning
 * @date 2019/9/8 00:08
 */
public class UserDAOTest extends LessionApplicationTests {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void testSelect() {
        User user = userDAO.selectById(1);
        Assert.assertNotNull(user);
        System.out.println(user);
    }

    @Test
    public void testSelectList() {
        List<User> list = userDAO.selectList(null);
        Assert.assertFalse(CollectionUtils.isEmpty(list));
        for (User u : list) {
            System.out.println(u);
        }
    }

    @Test
    public void testSelectListWithParam() {
        User user = new User();
        user.setId(1);
        List<User> list = userDAO.selectList(new QueryWrapper<User>().in("id",1,2,3));
        Assert.assertFalse(CollectionUtils.isEmpty(list));
        for (User u : list) {
            System.out.println(u);
        }
    }

    @Test
    public void pageHelperTest() {
        //获取第二页的两条信息
        PageHelper.startPage(2,2);
        List<User> list = userDAO.selectList(null);
        Assert.assertFalse(CollectionUtils.isEmpty(list));
        for (User u : list) {
            System.out.println(u);
        }
        //获取分页信息
        PageInfo<User> pageInfo = new PageInfo<>(list);
        Assert.assertNotNull(pageInfo);
        System.out.println(pageInfo);
    }

    @Test
    public void pageTest() {
        //获取第二页的两条信息
        IPage<User> page = new Page<>(2, 2);
        IPage<User> userIPage = userDAO.selectPage(page, new QueryWrapper<User>().in("id", 1, 2, 3, 4));
        Assert.assertFalse(CollectionUtils.isEmpty(userIPage.getRecords()));
        for (User u : userIPage.getRecords()) {
            System.out.println(u);
        }
        //获取分页信息
        Assert.assertNotNull(userIPage);
        System.out.println(userIPage.getTotal());
    }

}