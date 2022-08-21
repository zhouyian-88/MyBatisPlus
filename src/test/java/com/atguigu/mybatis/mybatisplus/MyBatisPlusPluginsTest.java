package com.atguigu.mybatis.mybatisplus;

import com.atguigu.mybatis.mybatisplus.pojo.User;
import com.atguigu.mybatis.mybatisplus.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-08-20-15:35
 */
//在Spring的环境中进行测试
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring的配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class MyBatisPlusPluginsTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage(){
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page, null);
        System.out.println("分页数据:"+page.getRecords());
        System.out.println("页面显示的条数:"+page.getSize());
        System.out.println("总记录数"+page.getTotal());
        System.out.println("总页数:"+page.getPages());
    }
    @Test
    public void testPageVo(){
        Page<User> page = new Page<>(1,3);
        userMapper.selectPageVo(page,20);
        System.out.println(page.getRecords());
    }
}
