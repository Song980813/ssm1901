package com.huayu.ssm_1901.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huayu.ssm_1901.mapper.PositionMapper;
import com.huayu.ssm_1901.pojo.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author dell
 */
@Service
@Transactional
public class PostService extends ServiceImpl<PositionMapper,Position> implements PostImpl {
    @Autowired
    private  PositionMapper positionMapper;

    @Override
    public List<Position> queryPost1(String str) {
        return positionMapper.query(str);
    }
}
