package com.note.web.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class ResponseEntity<T> implements Serializable {

    /**
     * 返回状态码
     */
    private int code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 分页总条数
     */
    private long total;

    /**
     * 分页数据集
     */
    private List<T> rows = new ArrayList<T>();

    /**
     * 数据模型
     */
    private Object data;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity(int code, String message, long total, List rows, Object data) {
        this.code = code;
        this.message = message;
        this.total = total;
        this.rows = rows;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @SuppressWarnings("rawtypes")
    public List getRows() {
        return rows;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void setRows(List rows) {
        this.rows = rows;
    }
}
