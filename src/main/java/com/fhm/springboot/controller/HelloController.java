package com.fhm.springboot.controller;

import com.fhm.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fhm on 2018/7/11.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello!";
    }
}
