package org.test3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by langye on 2017/12/13.
 */
@RestController
public class HelloWorld3 {

    @RequestMapping("/org/test3")
    //返回异常 http://localhost:8080/org/test3
    public int test3(){
        int i = 3/0;
        return i;
    }
}
