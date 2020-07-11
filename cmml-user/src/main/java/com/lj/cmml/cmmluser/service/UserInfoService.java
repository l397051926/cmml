package com.lj.cmml.cmmluser.service;

import com.lj.cmml.cmmluser.entity.UserInfo;
import com.lj.cmml.cmmluser.mapper.UserInfoMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lmx
 * @create: 2020/6/29
 **/
@Service
@Log4j2
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> getAllUser() {
        return userInfoMapper.selectList(null);
    }


}