package com.pang.fun.controller;

import com.pang.fun.pojo.UserInfo;
import com.pang.fun.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class sexNumController {
    @Autowired
    UserInfoService userInfoService;
    @CrossOrigin
    @GetMapping (value = "api/user/sexCount")
    @ResponseBody
    public int[] count() {
        int[] sexCnt = new int[2];
        sexCnt[0] = userInfoService.countSex("男");
        sexCnt[1] = userInfoService.countSex("女");
        System.out.println(sexCnt[0]+",****,"+sexCnt[1]);
        return sexCnt;
    }
}
