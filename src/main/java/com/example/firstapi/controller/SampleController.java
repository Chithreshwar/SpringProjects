package com.example.firstapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SampleController {

    @GetMapping("/sayhello")
    public String sayHello(){
        return "Hello, Everyone";
    }

    @GetMapping("/saybye/{name}")
    public String sayBye(@PathVariable("name") String name){
        return "Bye " + name + " Please come again!";
    }
}
