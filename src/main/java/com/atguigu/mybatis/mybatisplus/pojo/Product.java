package com.atguigu.mybatis.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-08-20-23:16
 */
@Data
@TableName("t_product")
public class Product {
    private Long id;

    private String name;

    private Integer price;
    @Version //标识乐观锁版本号字段
    private Integer version;
}
