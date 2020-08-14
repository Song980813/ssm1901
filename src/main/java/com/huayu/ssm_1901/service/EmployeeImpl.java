package com.huayu.ssm_1901.service;

import com.baomidou.mybatisplus.service.IService;
import com.huayu.ssm_1901.bo.MengerTree;
import com.huayu.ssm_1901.pojo.Employee;

import java.util.List;

/**
 *
 * @author dell
 */
public interface EmployeeImpl extends IService<Employee> {

      List<Employee> query(Employee employee);
      List<MengerTree> mengerQery(Integer mengerId);
}
