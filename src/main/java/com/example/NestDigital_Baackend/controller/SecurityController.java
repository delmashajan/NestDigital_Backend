package com.example.NestDigital_Baackend.controller;

import com.example.NestDigital_Baackend.dao.SecurityDao;
import com.example.NestDigital_Baackend.model.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class SecurityController {

    @Autowired

    private SecurityDao dao;



    @CrossOrigin(origins = "*")

    @PostMapping(path = "/addSec",consumes = "application/json",produces = "application/json")
    public Map<String,String> Addsecurity(@RequestBody Security s){

        dao.save(s);


        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewSec")
    public List<Security> Viewsecurity(@RequestBody Security s){
        return (List<Security>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchSec",consumes = "application/json",produces = "application/json")
    public List<Security> Searchsecurity(@RequestBody Security s){
        String seccode = String.valueOf(s.getSeccode());
        System.out.println(seccode);
        return (List<Security>) dao.Searchsecurity(s.getSeccode());


    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deleteSec",consumes = "application/json",produces = "application/json")
    public Map<String,String> Deletesecurity(@RequestBody Security s){
        String id = String.valueOf(s.getId());
        System.out.println(id);
        dao.Deletesecurity(s.getId());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }


}
