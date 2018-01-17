package com.lbj.demo.model;

import lombok.Data;

@Data
public class User {

    //用户Id
    private int id;
    //用户名
    private String name;
    //用户密码
    private String password;
}
