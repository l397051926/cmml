package com.lj.cmml.cmmluser.controller;

import com.lj.cmml.common.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
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
@Log4j2
public class VerifyController extends BaseController {

    @ApiOperation("用户模块 服务启动测试接口")
    @GetMapping("")
    public Result verify() {
        log.info("功能校验接口....");
        return success();
    }


}
