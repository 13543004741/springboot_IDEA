package org.test01.service;

import org.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.test01.mapper.UserMapper01;

/**
 * Created by langye on 2017/12/21.
 */
@Service
public class UserService01 {
    @Autowired
    private UserMapper01 userMapper01;

    public UserInfo selectUser(int id) {
        return userMapper01.selectUser(id);
    }

    //使用@Async实现异步调用(不使用此注解默认为同步)
    @Async
    public void sedSms(){
        System.out.println("sedSms结束执行2");
        for (int i =0;i<5;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i:"+i);
        }
        System.out.println("sedSms结束执行3");
    }
}
