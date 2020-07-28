package com.lj.cmml.cmmluser.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: lmx
 * @create: 2020/7/28
 **/
@ApiModel("登录参数")
@Data
public class LoginParam {

    @ApiModelProperty(name = "userName", value = "用户名字", required = true, example = "admin")
    private String userName;

    @ApiModelProperty(name = "password", value = "用户密码", required = true, example = "admin")
    private String passWord;

}
