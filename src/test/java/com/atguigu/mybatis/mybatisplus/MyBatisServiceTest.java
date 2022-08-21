package com.atguigu.mybatis.mybatisplus;

import com.atguigu.mybatis.mybatisplus.pojo.User;
import com.atguigu.mybatis.mybatisplus.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-08-19-14:55
 */
//在Spring的环境中进行测试
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring的配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class MyBatisServiceTest {

    @Resource(name = "userService")
    private UserService userService;

    @Test
    public void testGetCount(){
        User user = userService.getById(1l);
        System.out.println(user);
        long count = userService.count();
        System.out.println(count);

    }

    @Test
    public void testInsertMore(){
        //批量添加
        ArrayList<User> list = new ArrayList<>();
        User user = null;
        for (int i = 1; i < 10; i++) {
            user = new User();
            user.setName("zya"+i);
            user.setAge(16+i);
            user.setEmail("zya"+i+"@126.com");
            list.add(user);
        }
        boolean result = userService.saveBatch(list);
        System.out.println(result);
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1l);
        user.setName("李四");
        user.setEmail("lisi@126.com");
        userService.updateById(user);
    }

    @Test
    public void testDelete(){
        List<Long> longs = Arrays.asList(1l, 2l, 3l);
        boolean result = userService.removeByIds(longs);
        System.out.println(result);
    }


}
