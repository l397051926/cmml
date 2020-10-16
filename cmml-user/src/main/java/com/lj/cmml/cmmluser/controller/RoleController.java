package com.lj.cmml.cmmluser.controller;

import com.lj.cmml.cmmluser.entity.Role;
import com.lj.cmml.cmmluser.service.RoleService;
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
 * @create: 2020/8/14
 **/
@Api("权限模块")
@RestController
@RequestMapping("/role")
@Log4j2
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("获取全部角色")
    @GetMapping("/all")
    public Result getAll() {
        log.info("获取全部角色列表");
        List<Role> roles = roleService.getAll();
        return success(roles);
    }


}
