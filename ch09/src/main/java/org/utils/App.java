package org.utils;

import org.DBConfig.DBConfig01;
import org.DBConfig.DBConfig02;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by langye on 2017/12/18.
 */
@EnableAutoConfiguration
@EnableConfigurationProperties(value = {DBConfig01.class, DBConfig02.class})
//扫描controller层
@ComponentScan(basePackages = {"org.controller","org.utils","org.DBConfig","org.test01","org.test02","org.datasource"})

@MapperScan({"org.test01.mapper","org.test02.mapper"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
