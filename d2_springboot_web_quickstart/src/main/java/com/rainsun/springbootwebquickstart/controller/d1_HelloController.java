package com.rainsun.springbootwebquickstart.controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class d1_HelloController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello World");
        return "Hello World";
    }

}