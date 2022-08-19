package com.stu.service;

import com.stu.mapper.UserMapper;
import com.stu.pojo.User;
import com.stu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by e1hax on 2022-08-19.
 */
public class UserService {
    //1.利用工具类获取sqlSessionFactory
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public User login(String username,String password){
        //2.获取sqlsession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4.调用select方法
        User user = mapper.select(username, password);
        return user;
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    public boolean register(User user){
        //2.获取sqlsession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //判断用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());
        if (u == null) {
            //用户不存在
            //4.调用add方法
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return u == null;
    }


}
