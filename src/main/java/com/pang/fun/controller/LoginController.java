package com.pang.fun.controller;

import com.pang.fun.result.Result;
import com.pang.fun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import com.pang.fun.pojo.User;

import java.util.Objects;

/**
 * 系统使用人员的登录校验
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        User user = userService.get(username, requestUser.getPassword());
        String message;
        if (null == user) {
            message = "账号密码错误,请重新输入";
            return new Result(400, message);
        } else {
            message = "登录成功";
            return new Result(200, message);
        }
    }
}
