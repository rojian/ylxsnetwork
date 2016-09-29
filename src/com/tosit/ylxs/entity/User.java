package com.tosit.ylxs.entity;

/**
 * 封装user
 * Created by Administrator on 2016/9/26.
 */
public class User {

    private String username; //用户名
    private String password; //密码


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
