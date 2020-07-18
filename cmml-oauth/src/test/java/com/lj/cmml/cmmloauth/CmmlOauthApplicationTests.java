package com.lj.cmml.cmmloauth;

import com.lj.cmml.cmmloauth.feign.UserServiceClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = CmmlOauthApplication.class)
@RunWith(SpringRunner.class)
public class CmmlOauthApplicationTests {

    @Autowired
    private UserServiceClient userServiceClient;

    @Test
    public void contextLoads() {
        String s = userServiceClient.queryUserByName("admin");
        System.out.println(s);
    }

}
