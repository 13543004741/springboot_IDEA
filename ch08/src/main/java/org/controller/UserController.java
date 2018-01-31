package org.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test01.service.UserService01;
import org.test02.service.UserService02;

/**
 * Created by langye on 2017/12/19.
 */
@RestController
public class UserController {

    private  static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService01 userService01;
    @Autowired
    private UserService02 userService02;

    @RequestMapping("/add")
    public String add(){
        //此条数据保存在test01数据库
        userService01.addUser("test01","01");
        //此条数据保存在test02数据库
        userService02.addUser("test02","02");
        return "success";
    }

    @RequestMapping("/log")
    public String log(){
        logger.info("print log success");
        return "success";
    }
}
