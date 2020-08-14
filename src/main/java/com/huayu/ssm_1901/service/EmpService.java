package com.huayu.ssm_1901.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huayu.ssm_1901.bo.MengerTree;
import com.huayu.ssm_1901.mapper.EmployeeMapper;
import com.huayu.ssm_1901.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * empService 层
 * @author dell
 */
@Service
@Transactional
public class EmpService extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeImpl {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> query(Employee employee) {
        return employeeMapper.query(employee);
    }

    @Override
    public List<MengerTree> mengerQery(Integer mengerId) {
        Wrapper wrapper=new EntityWrapper<>();
        wrapper.eq("menger_id",mengerId);
        List<Employee> list=employeeMapper.selectList(wrapper);
        List<MengerTree> treeList=new ArrayList<>();
            for(Employee emp:list){
                MengerTree mengerTree=new MengerTree();
                mengerTree.setTitle(emp.getName());
                mengerTree.setChildren(mengerQery(emp.getId()));
                treeList.add(mengerTree);
            }
        return treeList;
    }


}
