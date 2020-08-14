package com.huayu.ssm_1901.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huayu.ssm_1901.pojo.Position;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author dell
 */
public interface PositionMapper extends BaseMapper<Position> {

    @SelectProvider(type = EmpSql.class,method = "queryPost")
    public List<Position> query(String str);
}