package org.controller;

import org.entity.UserInfo;
import org.test01.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by langye on 2017/12/19.
 */
@RestController
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/index")
    public String index(String userName){
       UserInfo userInfo =  userMapper.findName(userName);
        System.out.println(userInfo.toString());
        return userInfo.toString();
    }
}
