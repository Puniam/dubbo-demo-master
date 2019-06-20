package com.deepexi.user.domain.eo;

import com.deepexi.util.mapper.SuperEntity;

public class User extends SuperEntity {

    /**
     * 名称
     */
    private String userName;
    /**
     * 年龄
     */
    private int age;
    /**
     * 用户编号
     */
    private String userNumber;
    /**
     * 用户别名
     */
    private String nickName;
    /**
     * 用户邮箱
     */
    private String email;

    public User()  {
    }

    public User(String userName, int age,String userNumber, String nickName, String email) {
        this.userName = userName;
        this.age = age;
        this.userNumber = userNumber;
        this.nickName = nickName;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
