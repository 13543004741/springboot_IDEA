package org.controller;

import org.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test01.service.UserService01;

/**
 * Created by langye on 2017/12/19.
 */
@RestController
public class UserController {


    //获取自定义文件参数的注解
    @Value("${name}")
    private String name;

    @Autowired
    private UserService01 userService01;
    @Autowired
    private CacheManager cacheManager;

    @RequestMapping("/cache")
    public String cache(int id){
        UserInfo userInfo = userService01.selectUser(id);
        return "success :get-->"+userInfo.toString();
    }


    @RequestMapping("/remove")
    public String removerCache(){
        //根据xml配置的缓存名称清空缓存数据
        cacheManager.getCache("baseCache").clear();
        return "success";
    }

    @RequestMapping("/sedSms")
    public String sedSms(){
        System.out.println("###indexController###1");
        userService01.sedSms();
        System.out.println("###indexController###4");
        return "success";
    }

    @RequestMapping("/getName")
    public String getName(){
        return name;
    }
}
