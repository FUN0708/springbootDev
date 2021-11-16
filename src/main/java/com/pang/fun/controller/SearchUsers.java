package com.pang.fun.controller;

import com.pang.fun.pojo.User;
import com.pang.fun.result.Result;
import com.pang.fun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * 查询用户是否存在，存在返回true，否则返回false
 */
@Controller
public class SearchUsers {
    @Autowired
    UserService userService;
    @CrossOrigin
//    @PostMapping(value = "api/userInfo")
//    @ResponseBody
//    public List<User> list() throws Exception {
//        return userService.list();
//    }
    @PostMapping(value = "api/index")
    @ResponseBody
    public String find(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
//        User user = userService.get(username, requestUser.getPassword());
        if(userService.isExist(username)) {
            return "welcome";
        } else {
            return "sorry";
        }
    }
}
