package com.lj.cmml.cmmloauth.feign;

import org.springframework.stereotype.Component;

/**
 * @author: lmx
 * @create: 2020/6/23
 **/
@Component
public class UserServiceClientFallBack implements UserServiceClient {

    @Override
    public String queryUserByName(String userName) {
        return "用户查找失败 ---- user name: " + userName;
    }
}
