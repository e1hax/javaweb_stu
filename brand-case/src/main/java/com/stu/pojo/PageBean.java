package com.stu.pojo;

import java.util.List;

/**
 * Created by e1hax on 2022-08-23.
 */
public class PageBean<T> {
    // 总记录数
    private int totalCount;
    // 当前页数据
    private List<T> rows;

    public PageBean(int totalCount, List<T> rows) {
        this.totalCount = totalCount;
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public PageBean() {
    }


}
