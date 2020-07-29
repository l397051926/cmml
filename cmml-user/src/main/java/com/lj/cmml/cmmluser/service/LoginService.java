package com.lj.cmml.cmmluser.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lj.cmml.cmmluser.dto.LoginParam;
import com.lj.cmml.cmmluser.entity.UserInfo;
import com.lj.cmml.cmmluser.expections.UserException;
import com.lj.cmml.cmmluser.mapper.UserInfoMapper;
import com.lj.cmml.common.utils.EncryptionUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

/**
 * @author: lmx
 * @create: 2020/7/28
 **/
@Service
@Log4j2
public class LoginService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    public JSONObject login(LoginParam loginParam) {
        JSONObject data = new JSONObject();
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(UserInfo::getUserName, loginParam.getUserName()).eq(UserInfo::getPassword, EncryptionUtils.getMd5(loginParam.getPassWord()));
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        if(Objects.isNull(userInfo)){
            throw new UserException(0, "用户/密码错误 或用户名不存在");
        }
        data.put("token", UUID.randomUUID());
        return data;
    }
}
