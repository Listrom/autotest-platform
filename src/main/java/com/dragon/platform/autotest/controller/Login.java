package com.dragon.platform.autotest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 登录结果
     */
    @GetMapping("/only/root/login")
    public String loginGet(@RequestParam("username") String username, @RequestParam("password") String password) {
        String result = null;
        if ("root".equals(username)  && "123456".equals(password)) {
            result = "success";
        } else {
            result = "fail";
        }
        return result;
    }

//    @PostMapping("/only/root/login")
//    public String loginPost(@RequestParam("username") String username, @RequestParam("password") String password){
//
//    }

}
