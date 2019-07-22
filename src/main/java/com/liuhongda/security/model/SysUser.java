package com.liuhongda.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author by liu.hongda
 * @Description TODO
 * @Date 2019/7/22 14:20
 */

@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class SysUser {

    private Long id;
    private String username;
    private String password;


}
