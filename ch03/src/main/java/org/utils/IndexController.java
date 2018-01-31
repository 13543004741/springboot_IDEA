package org.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by langye on 2017/12/13.
 */
@Controller
@EnableAutoConfiguration
public class IndexController{

    @RequestMapping("index")
    public String index(){
        System.out.println("hello...");
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(IndexController.class,args);
    }
}
