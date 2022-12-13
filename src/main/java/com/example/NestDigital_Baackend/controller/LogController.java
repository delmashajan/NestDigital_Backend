package com.example.NestDigital_Baackend.controller;

import com.example.NestDigital_Baackend.dao.LogDao;
import com.example.NestDigital_Baackend.model.Log;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController

public class LogController {

    @Autowired
    private LogDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addlog",consumes = "application/json",produces = "application/json")
    public String addLog(@RequestBody Log l){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        l.setInDate(currentdate);
        l.setCheckOut(0);
        dao.save(l);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/logout",consumes = "application/json",produces = "application/json")
    public String logOutStatus(@RequestBody Log l){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        l.setOutDate(currentdate);
        dao.logOutStatus(l.getCheckOut(),l.getOutDate(),l.getId());
        return "{status:success}";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewalllogs")
    public List<Map<String,String>> viewAllLog(){
        return (List<Map<String, String>>) dao.viewAllLogBy();
    }

    @CrossOrigin(origins = "*")

    @PostMapping(path = "/viewlogbyid",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> viewLogByEmp(@RequestBody Log l){
        return (List<Map<String, String>>) dao.viewlogByEmpid(l.getEmpcode());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewcheckin")
    public List<Map<String,String>> viewAllcheckin(){
        return (List<Map<String, String>>) dao.viewlogByStatus();
    }
}
