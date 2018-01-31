package org.test3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by langye on 2017/12/13.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "org.test3")
public class App3 {

    public static void main(String[] args) {
        SpringApplication.run(App3.class,args);
    }
}
