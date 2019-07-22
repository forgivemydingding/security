package com.liuhongda.security.config;

import com.liuhongda.security.component.MyUserDetailsService;
import com.liuhongda.security.handler.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author by liu.hongda
 * @Description config for the security
 * @Date 2019/7/19 11:25
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置需要认证的请求
        http.csrf().disable().authorizeRequests().anyRequest().authenticated().and()
                //登录表单相关配置,这里做了successHandler成功登录后的重定向，若不配置则返回上一页面
                .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").successHandler(myAuthenticationSuccessHandler).failureUrl("/login?error").permitAll().and()
                //登出相关配置
                .logout().permitAll();
    }

    /**
     * 密码翻译
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

    /**
     * 默认忽略路径配置
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/static/**");
    }

    /**
     * 密码加密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
