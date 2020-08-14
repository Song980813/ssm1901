package com.huayu.ssm_1901.web;

import org.apache.shiro.crypto.hash.SimpleHash;

public class Test {
    public static void main(String[] args) {
        Object result=new SimpleHash("MD5","123","1234567898",1024);
        System.out.println(result);
    }
}
