package org.test2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by langye on 2017/12/12.
 * 这个类为springboot第二种启动方式
 */
@RestController
public class HelloWorld2 {

    @RequestMapping("/org/test2")
    //http://localhost:8080/org/test2
    public String test2(){
        return "success";
    }
}
