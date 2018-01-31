package org.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by langye on 2017/12/11.
 */

/**
 *
 * @RestController == @responseBody(返回请求的json格式)+@Controller
 * @EnableAutoConfiguration 自动激活spring配置(此注解不能在项目中出现两次运行的地方)
 * 这个类为springboot第一种启动方式
 */
@EnableAutoConfiguration
@RestController
public class HelloWorld {

    @RequestMapping("/org/utils")
    //http://localhost:8080/org/test
    public String test(){
        return "success";
    }

    public static void main(String[] args) {
        //运行
        SpringApplication.run(HelloWorld.class,args);
    }
}
