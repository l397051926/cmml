package com.lj.cmml.cmmluser.service;

import com.lj.cmml.cmmluser.CmmlUserApplication;
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
public class UserServiceTest {

    @Autowired
    private UserInfoService userInfoService;


    @Test
    public void helloTest(){
        log.info("hello user info test");
    }


}
