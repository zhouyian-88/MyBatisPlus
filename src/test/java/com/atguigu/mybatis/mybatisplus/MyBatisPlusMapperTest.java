package com.atguigu.mybatis.mybatisplus;

import com.atguigu.mybatis.mybatisplus.mapper.ProductMapper;
import com.atguigu.mybatis.mybatisplus.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-08-20-23:18
 */
//在Spring的环境中进行测试
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring的配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class MyBatisPlusMapperTest {

    @Autowired
    private ProductMapper productMapper;
    @Test
    public void testProduct(){
        //小李查询商品价格
        Product productLi = productMapper.selectById(1l);
        System.out.println("小李查询到商品的价格："+productLi.getPrice());
        //小王查询商品价格
        Product productWang = productMapper.selectById(1l);
        System.out.println("小王查询到商品的价格："+productWang.getPrice());
        //小李将商品的价格+50
        productLi.setPrice(productLi.getPrice()+50);
        productMapper.updateById(productLi);
        //小王将商品的价格-30
        productWang.setPrice(productWang.getPrice()-30);
        int result = productMapper.updateById(productWang);
        if(result==0){
            //操作失败，重试
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice()-30);
           productMapper.updateById(productNew);
        }

        //老板查询商品价格
        Product productBoss = productMapper.selectById(1l);
        System.out.println("老板查询到商品的价格："+productBoss.getPrice());
    }
}
