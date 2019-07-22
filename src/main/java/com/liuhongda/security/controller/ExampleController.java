package com.liuhongda.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by liu.hongda
 * @Description TODO
 * @Date 2019/7/15 15:47
 */

@RestController
public class ExampleController {

    @GetMapping("/test")
    public String test(){
        return "test run";
    }
}
