package com.example.NestDigital_Baackend.controller;

import com.example.NestDigital_Baackend.dao.LeaveDao;
import com.example.NestDigital_Baackend.model.Leaves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {

    @Autowired
    private LeaveDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addLeave", consumes = "application/json", produces = "application/json")
    public String addLeave(@RequestBody Leaves l) {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentdate = String.valueOf((dt.format(now)));
        l.setApplyDate(currentdate);
        dao.save(l);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updatestatus", consumes = "application/json", produces = "application/json")
    public String updateStatus(@RequestBody Leaves l) {
        dao.updateById(l.getStatus(), l.getId());
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewallleaves")
    public List<Map<String, String>> viewallleaves() {
        return (List<Map<String, String>>) dao.viewAllLeaveBy();
    }



    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewleavesbyempid",consumes = "application/json",produces = "application/json")
    public  List<Map<String,String>> viewLeavesById(@RequestBody Leaves lm){
        return (List<Map<String, String>>) dao.viewLeaveById(lm.getEmpcode());
    }
}

