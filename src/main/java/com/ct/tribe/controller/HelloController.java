package com.ct.tribe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CT
 * @description
 */
@RestController
public class HelloController {
    @RequestMapping
    public String hello(){
        return "hello world";
    }
}
