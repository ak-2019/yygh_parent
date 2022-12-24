package com.atguigu.yygh.order.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @Author chengankang
 * @Date 2022/12/11 16:05
 * @Description
 */
@Configuration//声明一个类为配置类，将想要的组件添加到容器中
@MapperScan("com.atguigu.yygh.order.mapper")
public class OrderConfig {
}
