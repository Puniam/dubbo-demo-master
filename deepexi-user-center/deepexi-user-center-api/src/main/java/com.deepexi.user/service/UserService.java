package com.deepexi.user.service;

import com.deepexi.user.domain.eo.User;
import com.deepexi.util.pageHelper.PageBean;

public interface UserService {
    PageBean getUserList(Integer page, Integer size, int age);

    User getUserById(String id);

    Integer createUser(User user);

    Integer deleteUserById(String id);

    Integer update(User user);

}
