package com.atguigu.mybatisx.test;

import com.atguigu.mybatisx.mapper.UserMapper;
import com.atguigu.mybatisx.pojo.User;
import com.atguigu.mybatisx.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-08-21-13:32
 */
//在Spring的环境中进行测试
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring的配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class MyBatisXTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void testSelectAllById(){
        List<User> list = userMapper.selectAll();
        list.forEach(System.out::println);
    }
    @Test
    public void testGetAllUser(){
        List<User> list = userService.getAllUser();
        list.forEach(System.out::println);
    }
    @Test
    public void test01(){
        List<User> list = userMapper.selectAllOrderByAge();
        list.forEach(System.out::println);
    }
}
