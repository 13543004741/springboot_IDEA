package org.utils;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by langye on 2017/12/18.
 */
//扫描controller层
@ComponentScan(basePackages = {"org.controller", "org.test01.service"})
//扫描mapper
@MapperScan(basePackages = {"org.test01.mapper"})
@EnableAutoConfiguration
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
