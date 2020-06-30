package com.lj.cmml.cmmluser.configuration;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.lj.cmml.cmmluser.handler.MetaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lmx
 * @create: 2020/6/30
 **/
@Configuration
public class MyBatisPlusConfig {

    /**
     *	 自动填充功能
     * @return
     */
    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(new MetaHandler());
        return globalConfig;
    }

}
