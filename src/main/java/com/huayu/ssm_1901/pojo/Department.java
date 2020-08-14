package com.huayu.ssm_1901.pojo;

/**
 * 部门实体类
 * @author dell
 */
public class Department {
    private Integer id;

    private String dname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }
}