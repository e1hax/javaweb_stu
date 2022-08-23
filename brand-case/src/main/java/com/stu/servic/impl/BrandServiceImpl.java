package com.stu.servic.impl;

import com.stu.mapper.BrandMapper;
import com.stu.pojo.Brand;
import com.stu.pojo.PageBean;
import com.stu.servic.BrandService;
import com.stu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by e1hax on 2022-08-23.
 */
public class BrandServiceImpl implements BrandService {

    //1. 获取sqlsessionfactory
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll(){


        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取 BrandMapper 的class对象,通过 mapper调用方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();

        //4. 释放资源
        sqlSession.close();
        return brands;
    }

    @Override
    public void add(Brand brand) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取 BrandMapper 的class对象,通过 mapper调用方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);

        //4. 提交释放资源
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteByIds(int[] ids) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取 BrandMapper 的class对象,通过 mapper调用方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);

        //4. 提交释放资源
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取 BrandMapper 的class对象,通过 mapper调用方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.计算开始索引
        int begin = (currentPage-1) * pageSize;
        //  计算查询条目数
        int size=pageSize;

        //5.调用方法
        List<Brand> rows =  mapper.selectByPage(begin,size);
        int totalCount = mapper.selectTotalCount();
//        System.out.println(totalCount);

        //6.封装为PageBean
        PageBean pageBean = new PageBean<Brand>(totalCount,rows);
//        pageBean.setRows(rows);
//        pageBean.setTotalCount(totalCount);

        //7.释放资源
        sqlSession.close();
        return pageBean;
    }


    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取 BrandMapper 的class对象,通过 mapper调用方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.计算开始索引
        int begin = (currentPage-1) * pageSize;
        //  计算查询条目数
        int size=pageSize;

        // 处理brand条件，模糊表达式
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }

        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            brand.setCompanyName("%" + companyName + "%");
        }

        //5.调用方法
        List<Brand> rows =  mapper.selectByPageAndCondition(begin,size,brand);
        int totalCount = mapper.selectTotalCountByCondition(brand);

        //6.封装为PageBean
        PageBean<Brand> pageBean = new PageBean<Brand>(totalCount,rows);
//        pageBean.setRows(rows);
//        pageBean.setTotalCount(totalCount);

        //7.释放资源
        sqlSession.close();
        return pageBean;
    }

    @Override
    public void deleteById(int id) {
        //1.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.获取 BrandMapper 的class对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //3. 调用方法
        mapper.deleteById(id);

        //4.释放资源
        sqlSession.commit();
        sqlSession.close();

    }
}
