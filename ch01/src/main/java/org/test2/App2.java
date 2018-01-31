package org.test2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by langye on 2017/12/12.
 */
@ComponentScan(basePackages = "org.test2")
@EnableAutoConfiguration
public class App2 {

    public static void main(String[] args) {
        SpringApplication.run(App2.class,args);
    }
}
