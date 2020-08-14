package com.huayu.ssm_1901.web;

import com.baomidou.mybatisplus.service.IService;
import com.huayu.ssm_1901.pojo.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 部门管理
 * @author dell
 */
@RequestMapping("departServlet")
@Controller
public class DepartmentServlet {
    @Autowired
    private IService<Department> departService;

    static final Logger logger = LogManager.getLogger(DepartmentServlet.class.getName());

    @RequestMapping("queryDepart")
    @ResponseBody
    public List<Department> queryAll() {
         List<Department> list=departService.selectList(null);
         logger.info("部门查询成功");
         return list;
    }
}
