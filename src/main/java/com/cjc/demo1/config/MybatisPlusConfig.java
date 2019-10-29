package com.cjc.demo1.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@MapperScan("com.cjc.demo1.dao")  //dao包
public class MybatisPlusConfig {
    /**
     * 逻辑删除
     * */
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * SQL执行效率插件 设置 dev test 环境开启
     */
    @Bean
    @Profile({"dev","test"})
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

}
