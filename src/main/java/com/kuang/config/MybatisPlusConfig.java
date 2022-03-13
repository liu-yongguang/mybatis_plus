package com.kuang.config;/**
 * @author:Mr.Liu
 * @Date: 2022/2/28 16:54
 * @version: 1.0
 * @Description:
 */

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *@program: mybatis_plus
 *@description:
 *@author:Mr.Liu
 *@CreateDate: 2022/2/28 16:54
 *@version: 1.0
 *
 */

@Configuration
@EnableTransactionManagement
//@MapperScan(basePackages = "com.kuang.mapper")
@MapperScan(basePackages = "com.kuang.study.mapper")

public class MybatisPlusConfig {
    //注册乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return  new OptimisticLockerInterceptor();
    }
    //使用mybatisPlus内置的分页插件，2,使用Page对象
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    //逻辑删除组件
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }

    //SQL执行效率插件
    @Bean
    @Profile({"dev","test"})
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(100);//单位ms，如果超过了设置时间，则不会执行sql，抛出异常
        performanceInterceptor.setFormat(true);//是否格式化SQL语句

        return performanceInterceptor;
    }
}
