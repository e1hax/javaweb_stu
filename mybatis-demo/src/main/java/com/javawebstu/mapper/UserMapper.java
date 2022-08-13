package com.javawebstu.mapper;

import com.javawebstu.pojo.User;

import java.util.List;


/**
 * Created by e1hax on 2022-08-08.
 */
public interface UserMapper {

    List<User> selectAll();

    User selectById(int id);

}
