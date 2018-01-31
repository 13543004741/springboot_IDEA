package org.utils;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by langye on 2017/12/18.
 */
@EnableAutoConfiguration
//扫描controller层
@ComponentScan(basePackages = {"org.controller","org.test01","org.test02","org.datasource"})

@MapperScan({"org.test01.mapper","org.test02.mapper"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
