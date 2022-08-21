package com.atguigu.mybatisx.service;

import com.atguigu.mybatisx.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author ZHOUYIAN
* @description 针对表【user】的数据库操作Service
* @createDate 2022-08-21 13:16:41
*/
public interface UserService extends IService<User> {

    /**
     * 得到所用用户信息
     * @return
     */
    List<User> getAllUser();
}
