package com.pang.fun.service;

import com.pang.fun.dao.UserDao;
import com.pang.fun.dao.UserInfoDao;
import com.pang.fun.pojo.UserInfo;
import com.pang.fun.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 服务层
 * 数据库查询方法的接口实现
 */

@Service
public class UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;
    public void addUser(UserInfo userInfo) { // 保存用户数据
        userInfoDao.saveAndFlush(userInfo);
    }
    public Result isExist(int id) {
        userInfoDao.flush();
        boolean flag = userInfoDao.existsById(id);
        if (flag) {
            return new Result(200, "保存成功");
        } else {
            return new Result(400, "保存失败");
        }
    }
//    public UserInfo getInfo(int id){
//        return userInfoDao.getByIdcard(id);
//    }
    public UserInfo getInfoName(String name){
        return userInfoDao.findByName(name);
    }

    public int countSex(String sex){
        return userInfoDao.countUserInfoBySex(sex);
    }
    public List<UserInfo> findAll(){ return userInfoDao.findAll(); }
    @Transactional
    public int delUserInfo(int idCard) {return userInfoDao.deleteByIdcard(idCard);}

    public UserInfo findUserInfoById(int idCard){return userInfoDao.findByIdcard(idCard);}
}
