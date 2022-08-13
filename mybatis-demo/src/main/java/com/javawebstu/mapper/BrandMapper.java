package com.javawebstu.mapper;

import com.javawebstu.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by e1hax on 2022-08-09.
 */
public interface BrandMapper {

    //查询所有
    List<Brand> selectAll();

    //查看详情：根据id查询
    Brand selectById(int id);

    /**
     * 多条件查询
     */
//    List<Brand> selectByCondition(@Param("status")int status,@Param("companyName")String companyName,@Param("brandName")String brandName);
//    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);


    /**
     * 单条件查询
     * @param brand
     * @return
     */
    List<Brand> selectByConditionSingle(Brand brand);

    /**
     * 添加
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改
     */
    int update(Brand brand);

    /**
     * 根据id删除
     */
    void deleteById(int id);

    /**
     * 根据id批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);


}
