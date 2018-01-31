package org.test02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test02.mapper.UserMapper02;

/**
 * Created by langye on 2017/12/21.
 */
@Service
public class UserService02 {
    @Autowired
    private UserMapper02 userMapper02;

    public int addUser(String name,String password){
        return userMapper02.addUser(name,password);
    }
}
