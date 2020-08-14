package com.huayu.ssm_1901.service;

import com.baomidou.mybatisplus.service.IService;
import com.huayu.ssm_1901.pojo.Position;

import java.util.List;

/**
 * @author dell
 */
public interface PostImpl extends IService<Position> {

    public List<Position> queryPost1(String str);
}
