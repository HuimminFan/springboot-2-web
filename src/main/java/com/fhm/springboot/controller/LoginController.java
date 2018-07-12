package com.fhm.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by fhm on 2018/7/12.
 */

@Controller
public class LoginController {
//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Map<String,Object> map){

        if(!StringUtils.isEmpty(username) && "111111".equals(password))
            return "dashboard";
        else {
            map.put("msg","用户名或密码错误");
            return "login";
        }

    }
}
