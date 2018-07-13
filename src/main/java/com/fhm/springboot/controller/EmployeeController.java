package com.fhm.springboot.controller;

import com.fhm.springboot.dao.EmployeeDao;
import com.fhm.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * Created by fhm on 2018/7/13.
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "/emp/list";
    }
}
