package com.huayu.ssm_1901.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huayu.ssm_1901.mapper.buildMapper;
import com.huayu.ssm_1901.pojo.build;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class buildService extends ServiceImpl<buildMapper, build> {

}
