package com.huayu.ssm_1901.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huayu.ssm_1901.mapper.DepartmentMapper;
import com.huayu.ssm_1901.pojo.Department;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 部门service层
 * @author dell
 */
@Service
@Transactional
public class DepartService extends ServiceImpl<DepartmentMapper,Department> {

}
