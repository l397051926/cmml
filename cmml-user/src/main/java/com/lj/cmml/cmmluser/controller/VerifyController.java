package com.lj.cmml.cmmluser.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lmx
 * @create: 2020/6/29
 **/
@Api(tags = "服务启动 自测模块")
@RestController
@RequestMapping("/test")
@Slf4j
public class VerifyController {

    @ApiOperation("用户模块 服务启动测试接口")
    @GetMapping("")
    public String verify(){
        log.info("功能校验接口....");
        return "我还活着...   一切正常...";
    }


}
