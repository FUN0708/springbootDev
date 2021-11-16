package com.pang.fun.dao;

import com.pang.fun.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username); // 通过用户名查找

    User getByUsernameAndPassword(String username,String password); // 通过用户名和密码查找

//    List<User> findAll(User user);
}
