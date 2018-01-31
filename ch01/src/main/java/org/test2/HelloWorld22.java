package org.test2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by langye on 2017/12/12.
 */
@RestController
public class HelloWorld22 {

    @RequestMapping("/org/test22")
    //http://localhost:8080/org/test22
    public String test22(){
        return "success";
    }
}
