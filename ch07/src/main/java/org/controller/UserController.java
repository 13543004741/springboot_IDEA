package org.controller;

import org.entity.UserInfo;
import org.test01.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    //加入事务（回滚）
    @Transactional
    public String index(Integer id){
       UserInfo userInfo =  userDao.findOne(id);
       int i = 1/0;
        System.out.println(i);
        return userInfo.toString();
    }
}
