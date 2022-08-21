package com.atguigu.mybatis.mybatisplus;

import com.atguigu.mybatis.mybatisplus.pojo.User;
import com.atguigu.mybatis.mybatisplus.mapper.TestMapper;
import com.atguigu.mybatis.mybatisplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

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
    @Test
    public void testMyBatisPlus(){
        //根据id查询用户信息
//            System.out.println(userMapper.selectById(1l));
//        List<Long> longs = Arrays.asList(1l, 2l, 3l);
//        List<User> users = userMapper.selectBatchIds(longs);
//        System.out.println(users);
//        Page<Object> objectPage = new Page<>();
//        objectPage.setCurrent(1l);
//        Map<String, Object> map = userMapper.selectUserById(1l);
//        System.out.println(map);

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setAge(20);
        user.setName("张三");
        user.setEmail("zhangsan@126.com");
        int result = userMapper.insert(user);
        System.out.println(result);
        System.out.println(user.getId());
    }
    @Test
    public void testDelete(){
        //根据id删除用户
       /* User user = new User();
        user.setId(1560196738747236354l);
        int result = userMapper.deleteById(user);
        System.out.println(result);*/
        //根据id批量删除用户信息
        List<Long> longs = Arrays.asList(1l, 2l, 3l);
        int result = userMapper.deleteBatchIds(longs);
        System.out.println(result);
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(4l);
        user.setAge(18);
        user.setName("stephen");
        user.setEmail("stephen@gamil.com");
        int result = userMapper.updateById(user);
        System.out.println(result);
    }


}