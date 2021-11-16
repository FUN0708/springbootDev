package com.pang.fun.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Proxy(lazy = false)
@Entity
@Table(name = "userinfo")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class UserInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcard")
    @Id
    int idcard; // 主键，但是这个表示的是用户的用户号，应该是唯一标识的
    String name;
    int age;
    String sex;
    String phone;
    public UserInfo(){} // 空构造器
    public UserInfo(int idcard, String name, int age, String sex, String phone) {
        this.idcard = idcard;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
    }

    public int getIdcard() {
        return idcard;
    }

    public void setIdcard(int idcard) {
        this.idcard = idcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
