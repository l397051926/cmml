package com.lj.cmml.cmmluser.controller;

import com.alibaba.fastjson.JSONObject;
import com.lj.cmml.cmmluser.dto.LoginParam;
import com.lj.cmml.cmmluser.service.LoginService;
import com.lj.cmml.common.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lmx
 * @create: 2020/7/28
 **/
@Api("登录登出模块")
@RestController
@Log4j2
public class LoginController  extends BaseController{

    @Autowired
    private LoginService loginService;

    @ApiOperation("用户登录接口")
    @PostMapping("/login")
    public Result getUsers(@RequestBody LoginParam loginParam) {
        log.info("查询 所有用户 列表:{}", loginParam);
        JSONObject data = loginService.login(loginParam);
        return success(data);
    }
}
