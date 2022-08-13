package com.javawebstu.mapper;

import com.javawebstu.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * Created by e1hax on 2022-08-08.
 */
public interface UserMapper {

    List<User> selectAll();


    @Select("select * from tb_user where id =#{id}" )
    User selectById(int id);


}
