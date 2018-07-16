package com.fhm.springboot.controller;

import com.fhm.springboot.dao.DepartmentDao;
import com.fhm.springboot.dao.EmployeeDao;
import com.fhm.springboot.entities.Department;
import com.fhm.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

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
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/emp")
    public String toAddPage(Model model){

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "/emp/add";
    }



    @PostMapping("/emp")
    public String addEmp(Employee employee){

        System.out.println("保存员工："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
