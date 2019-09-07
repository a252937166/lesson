package com.ouyang.lesson.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

}