package com.lj.cmml.cmmluser.service;

import com.alibaba.fastjson.JSON;
import com.lj.cmml.cmmluser.entity.User;
import com.lj.cmml.cmmluser.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lmx
 * @create: 2020/6/29
 **/
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUser(){
        return userMapper.selectList(null);
    }

}
