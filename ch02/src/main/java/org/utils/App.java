package org.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by langye on 2017/12/13.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "org.utils")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
