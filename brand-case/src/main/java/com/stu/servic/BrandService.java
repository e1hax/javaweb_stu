package com.stu.servic;

import com.stu.pojo.Brand;
import com.stu.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by e1hax on 2022-08-23.
 */
public interface BrandService {

    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 新增产品
     * @return
     */
    void add(Brand brand);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询
     * @param currentPage   当前页码
     * @param pageSize      每页展示条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */
    PageBean<Brand>  selectByPageAndCondition(int currentPage,int pageSize,Brand brand);


    /**
     * 删除
     * @param id
     */
    void deleteById(int id);

}
