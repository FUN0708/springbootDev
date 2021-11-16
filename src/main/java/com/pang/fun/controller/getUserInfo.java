package com.pang.fun.controller;

import com.pang.fun.pojo.UserInfo;
import com.pang.fun.result.Result;
import com.pang.fun.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

@Controller
public class getUserInfo {
    @Autowired
    UserInfoService userInfoService;
    @CrossOrigin
    @PostMapping(value = "api/user/showInfo")
    @ResponseBody
    public UserInfo get(@RequestBody UserInfo ui) throws Exception {
        // 对 html 标签进行转义，防止 XSS 攻击
//        System.out.println("userinfocontroller");
        String name = ui.getName();
        UserInfo u = userInfoService.getInfoName(name);
        if (u == null) {
            System.out.println("未查询到该用户，请重新输入");
        }
        return userInfoService.getInfoName(name);
    }
}
