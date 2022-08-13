package com.javawebstu;

import com.javawebstu.mapper.UserMapper;
import com.javawebstu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by e1hax on 2022-08-07.
 * MyBaties Mapper代理开发
 */
public class MyBatisDemo2 {

    public static void main(String[] args) throws IOException {
        //1. 加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession 对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();

        //4. 打印
        System.out.println(users);

        //5. 释放资源
        sqlSession.close();

    }
}
