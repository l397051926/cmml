package com.lj.cmml.cmmloauth.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: lmx
 * @create: 2020/6/23
 **/
@FeignClient(name = "user-server", url = "http://127.0.0.1:9111/user")
public interface UserServiceClient {

    @RequestMapping(value = "/user-info/queryUserByName", method = RequestMethod.GET)
    String queryUserByName(@RequestParam("userName") String userName);

}
