package com.example.NestDigital_Baackend.controller;

import com.example.NestDigital_Baackend.dao.EmployeeDao;
import com.example.NestDigital_Baackend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
}
