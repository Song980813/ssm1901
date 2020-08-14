package com.huayu.ssm_1901.pojo;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 职位实体类
 * @author dell
 */
@TableName("position")
public class Position {
    private Integer pid;

    private String pname;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }
}