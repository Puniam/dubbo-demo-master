package com.deepexi.user.mapper;

import com.deepexi.user.domain.eo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> selectPageVo(@Param("begin") Integer begin,@Param("size") Integer size,@Param("age") Integer age); //实现分页查询
    Integer selectTotalElement();
    User selectById(@Param("id") String id);
    Integer update(User user);
    Integer deleteById(@Param("id") String id);
    Integer insert(User user);
}
