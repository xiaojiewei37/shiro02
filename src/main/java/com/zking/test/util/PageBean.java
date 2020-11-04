package com.zking.test.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 分页工具类
 */
public class PageBean {

    // 公共参数
    private int page = 1;// 页码
    private int rows = 10;// 页大小
    private int total = 0;// 总记录数
    private boolean pagination = true;// 是否分页

    private String url;// 根目录+请求地址

    private Map<String, String[]> parameterMap;// 请求参数

    public PageBean() {
        super();
    }

    /**
     * 对PageBean进行初始化
     *
     * @param request
     */
    public void setRequest(HttpServletRequest request) {
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        String pagination = request.getParameter("pagination");
        this.setPage(page);
        this.setRows(rows);
        this.setPagination(pagination);

        this.url = request.getContextPath() + request.getServletPath();
        this.parameterMap = request.getParameterMap();

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String[]> getParameterMap() {
        return parameterMap;
    }

    public void setParameterMap(Map<String, String[]> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPage(String page) {
        if (null != page && !"".equals(page.trim())) {
            this.page = Integer.parseInt(page);
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setRows(String rows) {
        if (null != rows && !"".equals(rows.trim())) {
            this.rows = Integer.parseInt(rows);
        }
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTotal(String total) {
        this.total = Integer.parseInt(total);
    }

    public boolean isPagination() {
        return pagination;
    }

    public void setPagination(boolean pagination) {
        this.pagination = pagination;
    }

    public void setPagination(String pagination) {
        pagination = null == pagination ? "" : pagination.trim();
        if ("false".equalsIgnoreCase(pagination)) {
            this.pagination = false;
        } else {
            this.pagination = true;
        }
    }

    /**
     * 获得起始记录的下标
     *
     * @return
     */
    public int getStartIndex() {
        return (this.page - 1) * this.rows;
    }

    /**
     * 最大页
     *
     * @return
     */
    public int getMaxPage() {
        int max = this.total / this.rows;
        if (this.total % this.rows != 0) {
            max++;
        }
        return max;
    }

    /**
     * 下一页
     *
     * @return
     */
    public int getNextPage() {
        int nextPage = page + 1;
        if (nextPage > this.getMaxPage()) {
            nextPage = getMaxPage();
        }
        return nextPage;
    }

    /**
     * 上一页
     *
     * @return
     */
    public int getPreviousPage() {
        int previousPage = this.page - 1;
        if (previousPage < 1) {
            previousPage = 1;
        }
        return previousPage;
    }

    @Override
    public String toString() {
        return "PageBean [page=" + page + ", rows=" + rows + ", total=" + total + ", pagination=" + pagination + "]";
    }

}
