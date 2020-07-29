package com.lj.cmml.cmmluser.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lj.cmml.cmmluser.dto.UserParam;
import com.lj.cmml.cmmluser.entity.UserInfo;
import com.lj.cmml.cmmluser.expections.UserException;
import com.lj.cmml.cmmluser.mapper.UserInfoMapper;
import com.lj.cmml.common.utils.EncryptionUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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


    public UserInfo querUserByName(String userName) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getUserName, userName);
        return userInfoMapper.selectOne(queryWrapper);
    }

    public void addUser(UserParam userParam) {
        UserInfo info = querUserByName(userParam.getUserName());
        if (Objects.nonNull(info)) {
            throw new UserException(0, "用户名已经存在");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userParam.getUserName());
        userInfo.setPassword(EncryptionUtils.getMd5(userParam.getPassWord()));
        userInfo.setUnit(userParam.getUnit());
        userInfo.setEmail(userParam.getEmail());
        userInfo.setPhone(userParam.getPhone());

        userInfoMapper.insert(userInfo);

    }
}
