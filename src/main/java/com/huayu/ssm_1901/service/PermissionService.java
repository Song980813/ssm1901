package com.huayu.ssm_1901.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huayu.ssm_1901.mapper.PermissionMapper;
import com.huayu.ssm_1901.pojo.Permission;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dell
 */
@Service
@Transactional
public class PermissionService extends ServiceImpl<PermissionMapper, Permission> implements PermissionImpl{
}
