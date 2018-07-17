package com.fhm.springboot.controller;

import com.fhm.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(UserNotExistException.class)
    public String handelException(Exception e, HttpServletRequest request){

        Map<String,Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);

        map.put("code","user.notexist");
        map.put("message","用户出错了！");
        request.setAttribute("ext",map);

        return "forward:/error";
    }
}
