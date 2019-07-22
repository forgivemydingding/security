package com.liuhongda.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author by liu.hongda
 * @Description config for the security
 * @Date 2019/7/19 11:25
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置需要认证的请求
        http.csrf().disable().authorizeRequests().anyRequest().authenticated().and()
        //登录表单相关配置
        .formLogin().usernameParameter("username").passwordParameter("password").failureUrl("/login?error").permitAll().and()
        //登出相关配置
        .logout().permitAll();
    }
}
