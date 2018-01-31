package org.controller;

import org.test01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by langye on 2017/12/18.
 */
@RestController
public class IndexController {
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        userService.createJdbcUser();
        return "add success";
    }
}
