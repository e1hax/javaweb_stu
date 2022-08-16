package com.stu.mapper;

import com.stu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by e1hax on 2022-08-16.
 */
public interface UserMapper {


    /**
     * 登录，更具用户名密码判断是否登录成功
     * @param username
     * @param password
     * @return
     */
    @Select("select * from tb_users where username=#{username} and password=#{password}")
    User select(@Param("username") String username,@Param("password") String password);


    /**
     * 更具用户名判断用户是否存在
     * @param username
     * @return
     */
    @Select("select * from tb_users where username=#{username}")
    User selectByUsername(String username);


    /**
     * 用户注册
     * @return
     */
    @Insert("insert into tb_users values(null,#{username},#{password})")
    void add(User user);

}
