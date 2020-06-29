package com.lj.cmml.cmmluser.controller;

import com.lj.cmml.cmmluser.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lmx
 * @create: 2020/6/29
 **/
@Api("用户模块")
@RestController
@RequestMapping("/user-info")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public String getUsers(){
        log.info("查询 所有用户 列表");
       return userService.getAllUser();
    }

}
