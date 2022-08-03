package com.utindus.lp11.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/departments")
    public String helloworld()
        {
            return welcomeMessage;
        }
}
