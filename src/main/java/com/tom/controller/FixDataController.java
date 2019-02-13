package com.tom.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tom.service.FixDataService;

@RestController
@RequestMapping("/fixdata")
public class FixDataController
{
    @Autowired
    private FixDataService fixDataService;
    
    @RequestMapping("/")
    public String index() {
        try
        {
            fixDataService.fixData();
        }
        catch (ParseException e)
        {
              
            // TODO Auto-generated catch block  
            e.printStackTrace();  
            
        }
        return "success";
    }
}
