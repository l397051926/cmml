package com.lj.cmml.cmmluser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: lmx
 * @create: 2020/6/29
 **/
@Data
@TableName("user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String userName;
    private Integer age;
}
