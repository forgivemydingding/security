package com.liuhongda.security.web;

import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author by liu.hongda
 * @Description 使用@WebListener注解，实现ServletContextListener接口
 * @Date 2019/8/9 15:24
 */

@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContex初始化");
        servletContextEvent.getServletContext().addListener(HttpSessionEventPublisher.class);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContex销毁");
    }
}
