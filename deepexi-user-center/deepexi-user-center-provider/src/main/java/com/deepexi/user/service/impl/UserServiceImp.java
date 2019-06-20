package com.deepexi.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.deepexi.user.domain.eo.User;
import com.deepexi.user.mapper.UserMapper;
import com.deepexi.user.service.UserService;
import com.deepexi.util.pageHelper.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public PageBean getUserList(Integer page, Integer size, int age) {
        List<User> users = userMapper.selectPageVo((page-1)*size,size,age);
        for(User user : users)
            System.out.println(user.getId());
        Integer totalElements = userMapper.selectTotalElement();
        Integer totalPages = totalElements%size>0?totalElements/size+1:totalElements/size;
        PageBean<User> pageBean = new PageBean<User>(users);
        pageBean.setContent(users);
        pageBean.setSize(size);
        pageBean.setNumber(page);
        pageBean.setTotalPages(totalPages);
        pageBean.setTotalElements(totalElements);//总记录数
        if(users!=null)
        pageBean.setNumberOfElements(users.size());
         return pageBean;
    }

    @Override
    public User getUserById(String id) {

        return userMapper.selectById(id);
    }

    @Override
    public Integer createUser(User user) {

        return userMapper.insert(user);
    }

    @Override
    public Integer deleteUserById(String id) {
        return userMapper.deleteById(id);
    }

    @Override
    public Integer update(User user) {
        return userMapper.update(user);
    }

}
