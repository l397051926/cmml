package com.lj.cmml.cmmluser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lj.cmml.cmmluser.mapper")
public class CmmlUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmmlUserApplication.class, args);
    }

}
