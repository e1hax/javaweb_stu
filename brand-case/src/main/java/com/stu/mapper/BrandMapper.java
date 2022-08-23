package com.stu.mapper;

import com.stu.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 新增产品
     * @param brand
     */
    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    @ResultMap("brandResultMap")
    void add(Brand brand);


    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);


    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from tb_brand limit #{begin},#{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    /**
     * 查询数据总条数
     * @return
     */
    int selectTotalCount();


    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @return
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    /**
     * 根据条件查询总记录数
     * @return
     */
    int selectTotalCountByCondition(Brand brand);


    /**
     * 删除
     * @param id
     */
    void deleteById(int id);

    /**
     * 修改数据
     * @param brand
     */
    void update(Brand brand);

    /**
     * 根据ID查数据
     * @param id
     * @return
     */
    Brand selectById(int id);
}
