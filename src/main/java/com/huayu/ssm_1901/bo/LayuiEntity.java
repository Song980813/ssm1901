package com.huayu.ssm_1901.bo;

import java.io.Serializable;
import java.util.List;

/**
 * @author dell
 */
public class LayuiEntity implements Serializable {
    private Integer code;
    private String msg;
    private Integer count;
    private List data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LayuiEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", emp=" + data +
                '}';
    }
}
