package org.test01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.test01.mapper.UserMapper01;
import org.springframework.stereotype.Service;

/**
 * Created by langye on 2017/12/21.
 */
@Service
public class UserService01 {
    @Autowired
    private UserMapper01 userMapper01;

    public int addUser(String name,String password){
        return userMapper01.addUser(name,password);
    }
}
