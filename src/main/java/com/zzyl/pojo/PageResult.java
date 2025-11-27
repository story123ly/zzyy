package com.zzyl.pojo;

import lombok.Data;

import java.util.List;

/**
 * 分页结果包装
 *
 * @author itheima
 */
@Data
public class PageResult<T> {
    private Long total ;//总条数
    private Integer pageSize ;//每页条数
    private Long pages ;//总页码
    private Integer page ;//页码当前页码
    private List<T> records;//当前页数据

    public PageResult() {
    }

    public PageResult(Long total, Integer pageSize, Long pages, Integer page, List<T> records) {
        this.total = total;
        this.pageSize = pageSize;
        this.pages = pages;
        this.page = page;
        this.records = records;
    }

}

