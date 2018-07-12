package com.fhm.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fhm on 2018/7/11.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello!";
    }
}
