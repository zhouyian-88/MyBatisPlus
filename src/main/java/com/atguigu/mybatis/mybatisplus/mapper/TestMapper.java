package com.atguigu.mybatis.mybatisplus.mapper;

import com.atguigu.mybatis.mybatisplus.pojo.User;

import java.util.List;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-08-18-15:03
 */
public interface TestMapper {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getAllUser();
}
