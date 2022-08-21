package com.atguigu.mybatisx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mybatisx.pojo.User;
import com.atguigu.mybatisx.service.UserService;
import com.atguigu.mybatisx.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ZHOUYIAN
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-08-21 13:16:41
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }
}




