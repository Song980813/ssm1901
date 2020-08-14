package com.huayu.ssm_1901.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.huayu.ssm_1901.pojo.Employee;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author dell
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    /**
     * 多条件查询
     * @param employee
     * @return
     */
    @SelectProvider(type = EmpSql.class, method = "query")
    public List<Employee>  query(Employee employee);

    @Select("select * from employee")
    public List<Employee> queryAll(Page page);

}