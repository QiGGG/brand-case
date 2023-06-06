package com.itgq;

import com.itgq.dao.BrandDao;
import com.itgq.domain.Brand;
import com.itgq.domain.PageBean;
import com.itgq.service.IBrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootBrandCaseApplicationTests {

    @Autowired
    private IBrandService iBrandService;

    @Test
    void testInsert() {
        Brand brand = new Brand();
        brand.setBrandName("iPhone");
        brand.setCompanyName("Apple");
        brand.setOrdered(1);
        brand.setDescription("iPhone");
        brand.setStatus(1);
        int flag = iBrandService.sInsert(brand);
        System.out.println(flag);
    }

    @Test
    void testDeleteById() {
        int flag = iBrandService.sDeleteById(52);
        System.out.println(flag);
    }

    @Test
    void testUpdate() {
        Brand brand = new Brand();
        brand.setBrandName("iPhone666");
        brand.setCompanyName("Apple666");
        brand.setOrdered(1);
        brand.setDescription("iPhone666");
        brand.setStatus(1);
        int flag = iBrandService.sUpdate(brand);
        System.out.println(flag);
    }

    @Test
    void testSelectByPage() {
        PageBean<Brand> pageBean = iBrandService.sSelectByPage(1,50);
        System.out.println("数据" + pageBean.getPageData());
    }

    @Test
    void testSelectByPageAndCondition() {
        Brand brand = new Brand();
        brand.setBrandName("京");
        PageBean<Brand> pageBean = iBrandService.sSelectByPageAndCondition(1, 50, brand);
        System.out.println("数据" + pageBean.getPageData());
    }

    @Autowired
    private BrandDao brandDao;

    @Test
    void testDaoSelectTotalCount() {
        int totalCount = brandDao.totalCount();
        System.out.println("数据" + totalCount);
    }

    @Test
    void testDaoInsert() {
        Brand brand = new Brand();
        brand.setBrandName("iPhone");
        brand.setCompanyName("Apple");
        brand.setOrdered(1);
        brand.setDescription("iPhone");
        brand.setStatus(1);
        brandDao.insert(brand);
    }

    @Test
    void testDaoDelete() {
        brandDao.delete(50);
    }

    @Test
    void testDaoSelectTotalCountAndCondition() {
        Brand brand = new Brand();
        brand.setBrandName("%京%");
        int totalCount = brandDao.totalCountAndCondition(brand);
        System.out.println("总数:" + totalCount);
    }

    @Test
    void testSplit() {
        String str = "7&7&8&8&9";
        String[] split = str.split("&");
        int ids[] = new int[split.length];
        for (int i = 0; i < split.length; i++){
            ids[i] = Integer.parseInt(split[i]);
            System.out.println(ids[i]);
        }
    }
}
