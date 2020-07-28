package com.lj.cmml.cmmluser.service;

import com.alibaba.fastjson.JSONObject;
import com.lj.cmml.cmmluser.dto.LoginParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author: lmx
 * @create: 2020/7/28
 **/
@Service
@Log4j2
public class LoginService {


    public JSONObject login(LoginParam loginParam) {
        JSONObject data = new JSONObject();
        data.put("token","token");
        return data;
    }
}
