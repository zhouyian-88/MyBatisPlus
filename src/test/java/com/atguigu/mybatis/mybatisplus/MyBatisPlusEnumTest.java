package com.atguigu.mybatis.mybatisplus;

import com.atguigu.mybatis.mybatisplus.pojo.User;
import com.atguigu.mybatis.mybatisplus.enums.SexEnum;
import com.atguigu.mybatis.mybatisplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-08-20-23:56
 */
//在Spring的环境中进行测试
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring的配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class MyBatisPlusEnumTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testEnum(){
        User user = new User();
        user.setName("lisi");
        user.setEmail("lisi@qq.com");
        user.setAge(15);
        user.setSex(SexEnum.FEMALE);

        int result = userMapper.insert(user);
        System.out.println(result);

    }
}
