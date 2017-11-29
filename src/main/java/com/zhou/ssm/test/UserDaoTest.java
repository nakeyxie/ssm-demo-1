package com.zhou.ssm.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhou.ssm.dao.UserDao;
import com.zhou.ssm.entity.User;

@RunWith(SpringJUnit4ClassRunner.class) //使用spring测试
@ContextConfiguration(locations = "classpath:spring-beans.xml") //设置spring配置文件路径
public class UserDaoTest {

    @Resource   //注入UserDao对象
    private UserDao userDao;

    @Test
    public void getUserData() throws Exception {
        User user= userDao.getUserData();
        System.out.println(user);
    }

}
