package com.lj.cmml.cmmluser.service;

import com.lj.cmml.cmmluser.CmmlUserApplication;
import com.lj.cmml.cmmluser.dto.LoginParam;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: lmx
 * @create: 2020/7/5
 **/
@SpringBootTest(classes = CmmlUserApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
public class LoginServiceTest {

    @Autowired
    private LoginService loginService;


    @Test
    public void helloTest(){
        log.info("hello user info test");
    }

    @Test
    public void loginTest(){
        LoginParam loginParam = new LoginParam();
        loginParam.setUserName("aa");
        loginParam.setUserName("aa");
        loginService.login(loginParam);
    }

}
