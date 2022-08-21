package com.atguigu.mybatis.mybatisplus.pojo;

import com.atguigu.mybatis.mybatisplus.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-08-18-14:45
 */
@Data
//用于设置实体类对应的数据库表名
@TableName("user")
public class User {
    //将当前所对应的字段指定为主键
    //@TableId注解的value属性用于指定主键的字段
    //@TableId注解中的type属性用于主键生成的策略
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    //指定属性对应的字段名
    @TableField("name")
    private String name;
    private Integer age;
    private String email;
    @TableLogic
    private Integer isDeleted;
    private SexEnum sex;
}
