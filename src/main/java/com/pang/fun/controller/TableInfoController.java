package com.pang.fun.controller;

import com.pang.fun.pojo.TableInfo;
import com.pang.fun.pojo.User;
import com.pang.fun.pojo.UserInfo;
import com.pang.fun.result.Result;
import com.pang.fun.service.UserInfoService;
import com.pang.fun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class TableInfoController {
    @Autowired
    UserInfoService userInfoService;
    @CrossOrigin
    /*
     * 员工信息列表查询
     */
    @GetMapping(value = "api/user/userInfo")
    @ResponseBody
    public List<UserInfo> tbInfo() {
        List<UserInfo> u = new ArrayList<>();
        u = userInfoService.findAll();
//        System.out.println(u.size());
        return u;
    }

    /*
     * 更新员工的信息
     */
    @PostMapping(value = "api/user/userInfoEdit")
    @ResponseBody
    public Result editUserInfo(@RequestBody UserInfo ui) {
        int idCard = ui.getIdcard();
        boolean flag = false;
        if (flag) {
            return new Result(200, "更新信息成功");
        } else {
            return new Result(400, "更新信息失败");
        }
    }
}
