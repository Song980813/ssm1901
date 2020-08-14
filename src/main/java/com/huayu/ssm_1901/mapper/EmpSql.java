package com.huayu.ssm_1901.mapper;

import com.huayu.ssm_1901.pojo.Employee;
import org.springframework.util.StringUtils;

public class EmpSql {
    public String query(Employee employee){
        StringBuffer sb=new StringBuffer("select * from employee where 1=1");
        if(!StringUtils.isEmpty(employee)){
            if(employee.getName()!=null){
                sb.append(" and name like '%${name}%'");
            }
            if(employee.getPostId()!=null){
                sb.append(" and post_id in (#{postId})");
            }
            if(employee.getDeptId()>0){
                sb.append(" and dept_id=#{deptId}");
            }
        }
        return sb.toString();
    }


    public String queryPost(String str){
        StringBuffer sb=new StringBuffer("select * from position where pid in");
        sb.append("(").append(str).append(")");
        return sb.toString();
    }
}
