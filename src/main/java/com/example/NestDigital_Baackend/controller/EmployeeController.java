package com.example.NestDigital_Baackend.controller;

import com.example.NestDigital_Baackend.dao.EmployeeDao;
import com.example.NestDigital_Baackend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class EmployeeController {

    @Autowired
    private EmployeeDao dao;

    @GetMapping("/home")
    public String Homepage(){
        return "welcome";
    }

    @CrossOrigin(origins = "*")

    @PostMapping(path = "/addEmployee",consumes = "application/json",produces = "application/json")
    public Map<String,String> Addemployee(@RequestBody Employee e){

        dao.save(e);
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewEmployee")
    public List<Employee> Viewemployee(@RequestBody Employee e){
        return (List<Employee>) dao.findAll();
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchEmployee",consumes = "application/json",produces = "application/json")
    public List<Employee> Searchemployee(@RequestBody Employee e){
        String empcode = String.valueOf(e.getEmpcode());
        System.out.println(empcode);
        return (List<Employee>) dao.Searchemployee(e.getEmpcode());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deleteEmployee",consumes = "application/json",produces = "application/json")
    public Map<String,String> Deleteemployee(@RequestBody Employee e){
        String id = String.valueOf(e.getId());
        System.out.println(id);
        dao.Deleteemployee(e.getId());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

}
