package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.TestMapper;
import com.atguigu.mybatisplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-08-18-15:21
 */
//在Spring的环境中进行测试
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring的配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class MyBatisPlusTest {

   /* @Autowired
    private TestMapper testMapper;
    @Test
    public void testMyBatis() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       TestMapper testMapper = context.getBean(TestMapper.class);
        testMapper.getAllUser().forEach(user -> {
            System.out.println(user);
        });
    }*/
   /*@Test
   public void testMyBatis(){
       ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
       TestMapper mapper = ac.getBean(TestMapper.class);
       mapper.getAllUser().forEach(user -> System.out.println(user));
   }*/
   @Autowired
   private TestMapper testMapper;
   @Autowired
   private UserMapper userMapper;
    @Test
    public void testMyBatisBySpring(){
        testMapper.getAllUser().forEach(user -> System.out.println(user));
    }
    @Test public void testMyBatisPlus(){
        //根据id查询用户信息
            System.out.println(userMapper.selectById(1));
        }
}