package com.liuhongda.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author by liu.hongda
 * @Description 权限实体实现GrantedAuthority接口，重写getAuthority方法，该方法唯一标识一个权限
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
