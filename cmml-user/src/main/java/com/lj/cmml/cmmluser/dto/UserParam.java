package com.lj.cmml.cmmluser.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: lmx
 * @create: 2020/7/29
 **/
@ApiModel("用户参数信息")
@Data
public class UserParam {

    @ApiModelProperty(name = "userName", value = "用户名字", required = true, example = "admin")
    private String userName;
    @ApiModelProperty(name = "passWord", value = "密码", required = true, example = "aaa")
    private String passWord;
    @ApiModelProperty(name = "email", value = "邮箱", example = "aaa@aaa.com")
    private String email;
    @ApiModelProperty(name = "unit", value = "单位", example = "hehe")
    private String unit;
    @ApiModelProperty(name = "phone", value = "电话", example = "13512345678")
    private String phone;
}
