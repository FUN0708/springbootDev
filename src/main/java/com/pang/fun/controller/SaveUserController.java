package com.pang.fun.controller;

import com.pang.fun.dao.UserDao;
import com.pang.fun.dao.UserInfoDao;
import com.pang.fun.pojo.User;
import com.pang.fun.pojo.UserInfo;
import com.pang.fun.result.Result;
import com.pang.fun.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

/**
 * 添加新的用户信息
 * 添加成功则返回成功的result
 * 添加失败则返回失败的result
 */
@Controller
public class SaveUserController {
    @Autowired
    UserInfoService userInfoService;
    @CrossOrigin
    @PostMapping (value = "api/user/userDetail")
    @ResponseBody
    public Result save(@RequestBody UserInfo requestUser) throws Exception {
        // 对 html 标签进行转义，防止 XSS 攻击
        String name = requestUser.getName();
        name = HtmlUtils.htmlEscape(name);
        UserInfo userInfo = new UserInfo(requestUser.getIdcard(), name,requestUser.getAge(),
                requestUser.getSex(), requestUser.getPhone());
        try{
            userInfoService.addUser(userInfo); // 添加员工
        } catch (Exception e) {
            return new Result(400, "保存失败");
        }
        return new Result(200, "保存成功");
    }
}
