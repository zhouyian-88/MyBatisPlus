package com.atguigu.mybatis.mybatisplus;

import com.atguigu.mybatis.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatis.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-08-19-16:52
 */
//在Spring的环境中进行测试
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring的配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class MyBatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        //查询用户名包含a，年龄在20到30之间，邮箱信息不为null的用户信息
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name","a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test02(){
        //查询用户信息，按照年龄降序排序，若年龄相等，则按照id升序排序
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age")
                .orderByAsc("id");
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test03(){
        //删除邮箱为空的用户
         QueryWrapper<User> wrapper = new QueryWrapper<>();
         wrapper.isNull("email");
        int result = userMapper.delete(wrapper);
        System.out.println("result:"+result);
    }

    @Test
    public void test04(){
        //将(年龄大于20且用户名中包含a)或邮箱为null的用户信息修改
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age ", 20)
                .like("name","a")
                .or()
                .isNull("email");
        User user = new User();
        user.setEmail("test@atguigu.com");
        int result = userMapper.update(user, wrapper);
        System.out.println("result:"+result);

    }

    @Test
    public void test05(){
        //将用户名中包含a且(年龄大于20或邮箱为null)的用户信息修改
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name","a")
                .and(i->i.gt("age", 20)
                        .or().isNull("email"));
        User user = new User();
        user.setEmail("test@atguigu.com");
        user.setName("张不是");
        int result = userMapper.update(user, wrapper);
        System.out.println("result:"+result);
    }
    @Test
    public void test06(){
        //查询用户的用户名、年龄和邮箱信息
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("name","age","email");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test07(){
        //查询id小于等于5的用户信息
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id", "select id from user where id <= 5");
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);

    }
    @Test
    public void test08(){
        //将用户名中包含a且(年龄大于20或邮箱为null)的用户信息修改
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.like("name", "a")
                .and(i->i.gt("age", 20).or().isNull("email"));
        wrapper.set("name", "张胜男").set("email", "zhang@atguigu.com");
        int result = userMapper.update(null, wrapper);
        System.out.println(result);
    }
    @Test
    public void test09(){
        String username = "";
        Integer startAge = 20;
        Integer endAge = 30;

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(username)){
            //如果username不为空字符串，不为null，不为空白符
            wrapper.like("name", username);
        }
        if(startAge!=null){
            wrapper.ge("age", startAge);
        }
        if(endAge!=null){
            wrapper.le("age", endAge);
        }
        //调用userMapper
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);

    }

    @Test
    public void test10(){
        String username = "a";
        Integer startAge = null;
        Integer endAge = 30;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(username), "name", username)
                .ge(startAge!=null,"age",startAge)
                .le(endAge!=null,"age",endAge);
        //调用userMapper
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);

    }

    @Test
    public void test11(){
        String username = "a";
        Integer startAge = null;
        Integer endAge = 30;

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(username),User::getName,username)
                .ge(startAge!=null, User::getAge,startAge)
                .le(endAge!=null, User::getAge,endAge);
        //调用userMapper
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);

    }

    @Test
    public void test12(){
        //将用户名中包含a且(年龄大于20或邮箱为null)的用户信息修改
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.like(User::getName, "a")
                .and(i->i.gt(User::getAge, 20).or().isNull(User::getEmail));
        wrapper.set(User::getName, "张三").set(User::getEmail, "zhang@atguigu.com");
        int result = userMapper.update(null, wrapper);
        System.out.println(result);
    }
}
