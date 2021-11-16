package com.pang.fun.controller;

import com.pang.fun.pojo.UserInfo;
import com.pang.fun.result.Result;
import com.pang.fun.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class delUserInfo {
    @Autowired
    UserInfoService userInfoService;
    @CrossOrigin
    @PostMapping(value = "/api/user/delUserInfo")
    @ResponseBody
    public Result delete(@RequestBody UserInfo ui) throws Exception {
        // 对 html 标签进行转义，防止 XSS 攻击
//        System.out.println("userinfocontroller");
        int id = ui.getIdcard();
        System.out.println("需要删除的id:"+ id);
        int flag = userInfoService.delUserInfo(id);
        if (flag > 0) {
            return new Result(200, "删除成功");
        }
        else return new Result(400, "删除失败");
    }
}
