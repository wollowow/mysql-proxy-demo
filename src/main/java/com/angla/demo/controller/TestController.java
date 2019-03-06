package com.angla.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * for test
 * Title:TestController
 *
 * @author liumenghua
 **/

@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/list")
    public Object toList(ModelAndView modelAndView) {
        System.out.println("123");
        return "success";
    }
}
