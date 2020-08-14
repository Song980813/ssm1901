package com.huayu.ssm_1901.error;

public class MyExecption extends Exception{
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MyExecption() {
        this.msg = msg;
    }

    public MyExecption(String msg) {
        super(msg);
        this.msg = msg;
    }
}
