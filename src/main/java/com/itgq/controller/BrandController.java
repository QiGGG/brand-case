package com.itgq.controller;


import com.itgq.domain.Brand;
import com.itgq.domain.PageBean;
import com.itgq.service.IBrandService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 高棋
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private IBrandService iBrandService;

    @PostMapping
    public String cInsert(@RequestBody Brand brand) {
        return iBrandService.sInsert(brand) > 0 ? "success" : "defeat";
    }

    @DeleteMapping("/deleteById/{id}")
    public String cDeleteById(@PathVariable Integer id) {
        return iBrandService.sDeleteById(id) > 0 ? "success" : "defeat";
    }

    @DeleteMapping("/deleteByIds")
    public String cDeleteByIds(@RequestBody Integer[] ids) {
        return iBrandService.sDeleteByIds(ids) > 0 ? "success" : "defeat";
    }

    @PutMapping
    public String cUpdate(@RequestBody Brand brand) {
        return iBrandService.sUpdate(brand) > 0 ? "success" : "defeat";
    }

//    @GetMapping
//    public List<Brand> cSelectAll(){
//        return iBrandService.sSelectAll();
//    }

    @GetMapping("/selectByPage")
    public PageBean<Brand> cSelectByPage(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize) {
        return iBrandService.sSelectByPage(currentPage, pageSize);
    }

    @PostMapping("/selectByPageAndCondition")
    public PageBean<Brand> cSelectByPageAndCondition(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize, @RequestBody Brand brand) {
        return iBrandService.sSelectByPageAndCondition(currentPage, pageSize, brand);
    }

}

