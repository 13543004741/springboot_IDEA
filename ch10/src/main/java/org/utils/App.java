package org.utils;

import org.DBConfig.DBConfig01;
import org.DBConfig.DBConfig02;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by langye on 2017/12/18.
 */
@EnableConfigurationProperties(value = {DBConfig01.class, DBConfig02.class})
//扫描controller层
@ComponentScan(basePackages = {"org.controller","org.utils","org.DBConfig","org.test01","org.test02","org.datasource"})

@MapperScan({"org.test01.mapper","org.test02.mapper"})

//开启注解缓存（当删除数据库相应记录若还能查询到数据，说明缓存开启成功）
@EnableCaching

//开启定时任务注解
@EnableScheduling

//异步调用注解
@EnableAsync

//启动Tomcat
@EnableAutoConfiguration
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
