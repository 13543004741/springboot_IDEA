package org.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by langye on 2017/12/28.
 */
@RestController
@EnableAutoConfiguration
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "success";
    }
    public static void main(String[] args) {
        SpringApplication.run(IndexController.class,args);
    }
}
