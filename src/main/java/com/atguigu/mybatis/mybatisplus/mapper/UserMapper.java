package com.atguigu.mybatis.mybatisplus.mapper;

import com.atguigu.mybatis.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-08-18-14:50
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    Map<String,Object> selectUserById(Long id);

    /**
     * 通过年龄查询用户信息并分页
     * @param page MyBatis-Plus 提供的分页对象，必须位于第一个参数的位置
     * @param age
     * @return
     */
    Page<User> selectPageVo(@Param("page") Page<User> page,@Param("age") Integer age);
}
