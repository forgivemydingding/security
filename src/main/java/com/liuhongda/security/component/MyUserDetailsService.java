package com.liuhongda.security.component;

import com.liuhongda.security.model.SysPermission;
import com.liuhongda.security.model.SysUser;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author by liu.hongda
 * @Description 获取用户信息和权限列表
 * @Date 2019/7/22 14:40
 */

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 模拟根据用户名查询用户信息和权限
        SysUser user = new SysUser(1L, "admin", "$2a$10$nm5H9QvnoWao.l7NbxQGZeZoR0Cn.VqCpsl3E/FhglPa954Zg9ccm", Arrays.asList(
                new SysPermission(1L, "用户列表", "user:view", "/getUserList", "GET"),
                new SysPermission(2L, "添加用户", "user:add", "/addUser", "POST"),
                new SysPermission(3L, "修改用户", "user:update", "/updateUser", "PUT")
        ));
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        System.out.println("进入UserDetailsService");
        return new User(user.getUsername(), user.getPassword(), user.getSysPermissions());
    }



    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("12345678"));
    }
}
