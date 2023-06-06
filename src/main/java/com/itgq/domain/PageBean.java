package com.itgq.domain;

import lombok.Data;

import java.util.List;

// 分页查询的JavaBean，泛型
// 封装返回给前端的数据
@Data
public class PageBean<T> {
    // 总记录数
    private Integer totalCount;
    // 当前页数据
    private List<T> pageData;

    public PageBean() {
    }

    public PageBean(Integer totalCount, List<T> pageData) {
        this.totalCount = totalCount;
        this.pageData = pageData;
    }
}
