package org.controller;

import org.entity.UserInfo;
import org.test01.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by langye on 2017/12/19.
 */
@RestController
public class UserController {


    @Autowired
    private UserDao userDao;

    @RequestMapping("/index")
    public String index(Integer id){
       UserInfo userInfo =  userDao.findOne(id);
        return userInfo.toString();
    }
}
