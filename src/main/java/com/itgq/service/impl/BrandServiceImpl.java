package com.itgq.service.impl;

import com.itgq.domain.Brand;
import com.itgq.dao.BrandDao;
import com.itgq.domain.PageBean;
import com.itgq.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 高棋
 * @since 2023-02-08
 */
@Service
public class BrandServiceImpl implements IBrandService {


    @Autowired
    private BrandDao brandDao;


    @Override
    public int sInsert(Brand brand) {
        return brandDao.insert(brand);
    }

    @Override
    public int sDeleteById(Integer id) {
        return brandDao.delete(id);
    }

    @Override
    public int sDeleteByIds(Integer[] ids) {
        return brandDao.deleteByIds(ids);
    }

    @Override
    public int sUpdate(Brand brand) {
        return brandDao.update(brand);
    }

    @Override
    public List<Brand> sSelectAll() {
        return brandDao.selectAll();
    }

    @Override
    public PageBean<Brand> sSelectByPage(int currentPage, int pageSize) {

        // 返回给前端的对象
        PageBean<Brand> pageBean = new PageBean<>();

        // 分页查询的开始索引和每页大小
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        // 每页的数据
        List<Brand> brands = brandDao.selectByPage(begin, size);
        pageBean.setPageData(brands);
        // 数据总数
        Integer totalCount = brandDao.totalCount();
        pageBean.setTotalCount(totalCount);

        return pageBean;
    }

    @Override
    public PageBean<Brand> sSelectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        // 返回给前端的对象
        PageBean<Brand> pageBean = new PageBean<>();

        // 分页查询的开始索引和每页大小
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        // 处理brand对象
        String brandName = brand.getBrandName();
        if(brandName != null && brandName.length() > 0){
            brand.setBrandName("%" + brandName + "%");
        }
        String companyName = brand.getCompanyName();
        if(companyName != null && companyName.length() > 0){
            brand.setCompanyName("%" + companyName + "%");
        }

        // 每页的数据
        List<Brand> brands = brandDao.selectByPageAndCondition(begin, size, brand);
        pageBean.setPageData(brands);
        // 数据总数
        Integer totalCount = brandDao.totalCountAndCondition(brand);
        pageBean.setTotalCount(totalCount);

        return pageBean;
    }
}
