package com.lj.cmml.cmmluser.controller;

import com.lj.cmml.cmmluser.entity.UserInfo;
import com.lj.cmml.cmmluser.service.UserInfoService;
import com.lj.cmml.common.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: lmx
 * @create: 2020/6/29
 **/
@Api(tags = "用户模块")
@RestController
@RequestMapping("/user-info")
@Log4j2
public class UserInfoController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation("获取全部用户列表")
    @GetMapping("/all")
    public Result getUsers() {
        log.info("查询 所有用户 列表");
        List<UserInfo> allUser = userInfoService.getAllUser();
        return success(allUser);
    }

}
