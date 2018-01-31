package org.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by langye on 2017/12/18.
 */
@EnableAutoConfiguration
//扫描controller层
@ComponentScan(basePackages = {"org.controller", "org.test01.service"})
//扫描dao层
@EnableJpaRepositories(basePackages = {"org.test01.mapper"})
//扫描实体
@EntityScan(basePackages = {"org.entity"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
