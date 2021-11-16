package com.pang.fun.service;

import com.pang.fun.dao.UserDao;
import com.pang.fun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public boolean isExist(String username){
        User user = getByName(username);
        return null != user;

    }
    public User getByName(String username) {
        return userDao.findByUsername(username);
    }

    public User get(String username, String password){
        return userDao.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDao.save(user);
    }
//    public List<User> list() {
//       return userDao.findAll();
//    }
}
