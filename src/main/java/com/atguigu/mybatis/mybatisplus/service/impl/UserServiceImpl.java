package com.atguigu.mybatis.mybatisplus.service.impl;

import com.atguigu.mybatis.mybatisplus.pojo.User;
import com.atguigu.mybatis.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatis.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-08-19-14:41
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
