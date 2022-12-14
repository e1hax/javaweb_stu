package com.stu.mapper;

import com.stu.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by e1hax on 2022-08-18.
 */
public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();


    /**
     * 新增
     * @param brand
     */
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status}) ")
    void add(Brand brand);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Select("select  * from tb_brand where id=#{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    /**
     * 修改数据
     */
    @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered}, description=#{description},status=#{status} where id=#{id}")
    @ResultMap("brandResultMap")
    void update(Brand brand);

    /**
     * 修改数据
     */
    @Delete("delete from tb_brand where id=${id}")
    @ResultMap("brandResultMap")
    void delete(int id);

}
