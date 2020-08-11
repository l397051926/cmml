package com.lj.cmml.cmmluser.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lj.cmml.cmmluser.dto.UserParam;
import com.lj.cmml.cmmluser.entity.UserInfo;
import com.lj.cmml.cmmluser.service.UserInfoService;
import com.lj.cmml.common.model.Result;
import com.lj.cmml.common.utils.ParameterUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("根据用户名字获取用户信息")
    @GetMapping("/queryUserByName")
    public Result queryUserByName(
            String userName
    ){
        log.info("根据用户名字 查询用户信息 用户名:{}", userName);
        UserInfo userInfo = userInfoService.querUserByName(userName);
        return success(userInfo);
    }


    @ApiOperation("添加用户")
    @PostMapping("/add")
    public Result addUser(
            @RequestBody UserParam userParam
            ){
        log.info("添加用户功能:{}", userParam);
        userInfoService.addUser(userParam);
        return success();
    }

    @ApiOperation("获取用户列表")
    @GetMapping("/list")
    public Result userList(@RequestParam(defaultValue = "0") Integer pageNo,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(value = "searchVal", required = false) String searchVal
    ){
        log.info("获取用户列表 pageNo:{}, pageSize{}, searchVal：{}", pageNo, pageSize, searchVal);
        searchVal = ParameterUtils.handleEscapes(searchVal);
        IPage<UserInfo> userList = userInfoService.list(pageNo, pageSize, searchVal);
        return success(userList);
    }



}
