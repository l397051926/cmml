package com.lj.cmml.cmmloauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.lj.cmml.cmmloauth.mapper")
@EnableFeignClients
public class CmmlOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmmlOauthApplication.class, args);
    }

}
