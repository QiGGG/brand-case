package com.itgq.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itgq.domain.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 高棋
 * @since 2023-02-08
 */

@Mapper
public interface BrandDao{

    /**
     * 新增数据
     * @param brand
     */
    @Insert("insert into tb_brand (brand_name, company_name, ordered, description, status) values (#{brandName},#{companyName},#{ordered},#{description},#{status});")
    public int insert(Brand brand);

    /**
     * 根据id删除
     * @param id
     */
    @Delete("delete from tb_brand where id = #{id};")
    public int delete(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */

    public int deleteByIds(@Param("ids") Integer[] ids);

    /**
     * 修改数据
     * @param brand
     */
    @Update("update tb_brand " +
            "set brand_name = #{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status} " +
            "where id = #{id};")
    public int update(Brand brand);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from tb_brand where id = #{id};")
    public Brand selectById(Integer id);

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from tb_brand")
    public int totalCount();


    @Select("select * from tb_brand")
    public List<Brand> selectAll();

    /**
     * 分页查询
     *
     * @return
     */
    @Select("select * from tb_brand limit #{begin}, #{size}")
    public List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);

    /**
     * 条件分类查询（模糊查询）
     * @param begin
     * @param size
     * @param brand
     * @return
     */
    public List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);

    /**
     * 条件查询总记录数
     * @return
     */
    public int totalCountAndCondition(Brand brand);
}
