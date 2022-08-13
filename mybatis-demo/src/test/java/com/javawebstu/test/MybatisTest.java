package com.javawebstu.test;

import com.javawebstu.mapper.BrandMapper;
import com.javawebstu.mapper.UserMapper;
import com.javawebstu.pojo.Brand;
import com.javawebstu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行sql
        List<Brand> brands = brandMapper.selectAll();
        System.out.println( brands);

        //5. 释放资源
        sqlSession.close();

    }

    @Test
    public void testSelectById() throws IOException {
        int id =1;

        //1. 加载 mybatis-config 核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行sql
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //5. 释放资源
        sqlSession.close();

    }

    @Test
    public void testSelectByCondition() throws IOException {
        //传入参数
        int status =1;
        String companyName ="华为";
        String brandName ="华为";
        //处理传入参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";

        // 传入实体类
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);

        //传入一个Map
        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        //map.put("brandName",brandName);

        //1. 加载 mybatis-config 核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行sql
//        List<Brand> brands = brandMapper.selectByCondition(id, companyName, brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();

    }

    @Test
    public void testSelectByConditionSingle() throws IOException {
        //传入参数
        int status =1;
        String companyName ="华为";
        String brandName ="华为";
        //处理传入参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";

        // 传入实体类
        Brand brand = new Brand();
        brand.setStatus(status);
        //brand.setBrandName(brandName);
        //brand.setCompanyName(companyName);

        //1. 加载 mybatis-config 核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行sql
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();

    }

    @Test
    public void testAdd() throws IOException {
        //传入参数
        int status =1;
        String companyName ="oppo公司";
        String brandName ="oppox21手机";
        int  ordered =19 ;
        String description ="音乐手机";

        // 传入实体类
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1. 加载 mybatis-config 核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行sql
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);

        //提交事务
//        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();

    }

    @Test
    public void testUpdate() throws IOException {
        //传入参数
        int status =10;
        //String companyName ="vivo公司";
        //String brandName ="vivo手机";
        //int  ordered =100 ;
        //String description ="拍照手机,非常牛皮";
        int id = 5;

        // 传入实体类
        Brand brand = new Brand();
        brand.setStatus(status);
        //brand.setBrandName(brandName);
        //brand.setCompanyName(companyName);
        //brand.setDescription(description);
        //brand.setOrdered(ordered);
        brand.setId(id);

        //1. 加载 mybatis-config 核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行sql
        int update = brandMapper.update(brand);
        System.out.println(update);

        //提交事务
//        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();

    }

    @Test
    public void testDeleteById() throws IOException {
        //传入参数
        int id = 5;

        //1. 加载 mybatis-config 核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行sql
        brandMapper.deleteById(id);

        //提交事务
//        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();

    }


    @Test
    public void testDeleteByIds() throws IOException {
        //传入参数
        int[] ids = {6,7,8};

        //1. 加载 mybatis-config 核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行sql
        brandMapper.deleteByIds(ids);

        //提交事务
//        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();

    }

    @Test
    public void testSelectUserById() throws IOException {
        //1.加载 mybatis-config 核心配置文件，获取sqlSessionFactory
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3。获取userMapper对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //4. 执行sql语句
        User user = userMapper.selectById(1);
        System.out.println(user);

        //5.释放资源
        sqlSession.commit();
    }

}
