package com.lj.cmml.cmmloauth.controller;

import com.lj.cmml.cmmloauth.feign.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lmx
 * @create: 2020/7/18
 **/
@RestController
public class HelloController {

    @Autowired
    private UserServiceClient userServiceClient;

    @GetMapping("/hello")
    public String  hello(){
        String admin = userServiceClient.queryUserByName("admin");

        return "hello";
    }
}
