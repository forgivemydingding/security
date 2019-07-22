package com.liuhongda.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author by liu.hongda
 * @Description TODO
 * @Date 2019/7/22 14:12
 */

@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class SysPermission implements GrantedAuthority {
    private Long id;
    private String name;
    private String code;
    private String url;
    private String method;

    @Override
    public String getAuthority() {
        return "ROLE_" + this.code + ":" + this.method.toUpperCase();
    }
}
