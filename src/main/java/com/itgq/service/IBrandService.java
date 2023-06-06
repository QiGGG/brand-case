package com.itgq.service;

import com.itgq.domain.Brand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itgq.domain.PageBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 高棋
 * @since 2023-02-08
 */
public interface IBrandService{

    /**
     * 增加数据
     * @param brand
     */
    public int sInsert(Brand brand);


    /**
     * 删除一行数据
     * @param id
     */
    public int sDeleteById(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int sDeleteByIds(Integer[] ids);

    /**
     * 修改数据
     * @param brand
     */
    public int sUpdate(Brand brand);

    /**
     * 查询所有
     * @return
     */
    public List<Brand> sSelectAll();

    /**
     * 分页查询，向前端返回一个对象，封装每行数据和数据总数
     * @param currentPage 数据库中数据从哪一条开始显示
     * @param pageSize  每页显示条数
     * @return
     */
    public PageBean<Brand> sSelectByPage(int currentPage, int pageSize);

    /**
     * 分页条件查询，向前端返回一个对象，封装每行数据和数据总数
     * @param currentPage 数据库中数据从哪一条开始显示
     * @param pageSize  每页显示条数
     * @param brand
     * @return
     */
    public PageBean<Brand> sSelectByPageAndCondition(int currentPage, int pageSize, Brand brand);

}
