package com.stu.service;

import com.stu.mapper.BrandMapper;
import com.stu.pojo.Brand;
import com.stu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by e1hax on 2022-08-18.
 */
public class BrandService {
    //1.利用工具类获取sqlSessionFactory
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有
     * @return
     */
    public List<Brand> selectAll() {
        //调用BrandMapper.selectAll()

        //2. 获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取 brandmapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4. 调用方法
        List<Brand> brands = mapper.selectAll();

        sqlSession.close();
        return brands;
    }

    /**
     * 添加
     * @param brand
     */
    public void add(Brand brand){

        //2. 获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取 brandmapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4. 调用方法
        mapper.add(brand);
        //5.提交事务
        sqlSession.commit();

        sqlSession.close();

    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Brand selectById(int id) {

        //2. 获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取 brandmapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4. 调用方法
        Brand brand = mapper.selectById(id);

        sqlSession.close();
        return brand;
    }

    public void update(Brand brand){
        //2. 获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取 brandmapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4. 调用方法
        mapper.update(brand);

        sqlSession.commit();
        sqlSession.close();
    }


    public void delete(int id) {

        //2. 获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取 brandmapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4. 调用方法
        mapper.delete(id);

        sqlSession.commit();
        sqlSession.close();
    }
}
