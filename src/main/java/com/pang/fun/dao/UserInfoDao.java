package com.pang.fun.dao;

import com.pang.fun.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 数据库查询语句的接口
 */
public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {
    UserInfo findByIdcard (int idCard);
    Boolean existsUserInfoByIdcard(int idCard);
    UserInfo findUserInfoByName(String name);
    UserInfo findByName(String name);
//    Boolean existsByName(String name);
    int countUserInfoBySex(String sex);
    Boolean deleteUserInfoByIdcard(int idCard);
    int deleteByIdcard(int idCard);
    @Override
    List<UserInfo> findAll();
}
