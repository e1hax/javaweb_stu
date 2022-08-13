package com.javawebstu.test;

import com.javawebstu.mapper.BrandMapper;
import com.javawebstu.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by e1hax on 2022-08-09.
 */
public class MybatisTest {
    @Test
    public void testSelectAll() throws IOException {
        //1. 加载 mybatis-config 核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        System.out.println( brands);

        //4. 释放资源
        sqlSession.close();

    }

}
