package com.example.springboot.entity;

import lombok.Data;

/**
 * *****************************************
 * 账户
 * @author 邓超【dengchao5@jd.com】
 * @date 2017/3/31 18:20
 * *****************************************
 */
@Data
public class Account {
    private long id;
    //登录名
    private String loginName;
    //密码
    private String password;
    //账户是否有效
    private boolean enabled;
}
