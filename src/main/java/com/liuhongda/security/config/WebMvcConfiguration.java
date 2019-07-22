package com.liuhongda.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author by liu.hongda
 * @Description 界面模板路径配置
 * @Date 2019/7/22 11:31
 */

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/getUserList").setViewName("userList");
        registry.addViewController("/getOrderList").setViewName("orderList");
    }
}
