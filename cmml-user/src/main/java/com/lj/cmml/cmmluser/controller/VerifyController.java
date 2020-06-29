package com.lj.cmml.cmmluser.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lmx
 * @create: 2020/6/29
 **/
@RestController
@RequestMapping("/test")
@Slf4j
public class VerifyController {

    @GetMapping("")
    public String verify(){
        log.info("功能校验接口....");
        return "一切正常...";
    }

}
