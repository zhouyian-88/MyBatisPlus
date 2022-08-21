package com.atguigu.mybatisx.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.atguigu.mybatisx.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author ZHOUYIAN
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-08-21 13:16:41
* @Entity com.atguigu.mybatisx.pojo.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

    int insertSelective(User user);

    List<User> selectAll();

    int updateAgeById(@Param("age") Integer age, @Param("id") Long id);

    int deleteByNameAndId(@Param("name") String name, @Param("id") Long id);

    List<User> selectAllOrderByAge();
}




