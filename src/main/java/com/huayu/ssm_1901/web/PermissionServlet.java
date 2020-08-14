package com.huayu.ssm_1901.web;

import com.baomidou.mybatisplus.service.IService;
import com.huayu.ssm_1901.bo.LayuiEntity;
import com.huayu.ssm_1901.pojo.build;
import com.huayu.ssm_1901.pojo.Permission;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PermissionServlet {
    @Autowired
    private IService<Permission> permissionIService;

    @Autowired
    private IService<build> buildIService;

    static final Logger logger = LogManager.getLogger(PermissionServlet.class.getName());

    @RequestMapping("permissionQuery")
    @ResponseBody
    @RequiresRoles(value = {"1","2","3","4"},logical = Logical.OR)
    public LayuiEntity queryAll(){
        List<Permission> list2=permissionIService.selectList(null);
        LayuiEntity layuiEntity= new LayuiEntity();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("查询成功");
        layuiEntity.setCount(list2.size());
        layuiEntity.setData(list2);
        logger.info("=============");
        logger.error("查询异常");
        return layuiEntity;
    }

    @RequestMapping("selectAll")
    public List<Permission> selectAll(){
       return permissionIService.selectList(null);
    }

    @RequestMapping("permissionQueryOne")
    public String queryOne(Integer id, Model model){
        Permission permission= permissionIService.selectById(id);
        model.addAttribute("perm",permission);
        return "/layuiTest/permissionUpdate.html";
    }

    @RequestMapping("permissionAdd")
    @RequiresRoles(value = {"1","2","3"},logical = Logical.OR)
    public void save(Permission permi){
        permissionIService.insert(permi);
    }

    @RequestMapping("permissionUpdate")
    @RequiresRoles(value = {"1","2","3"},logical = Logical.OR)
    public void update(Permission permi){
        permissionIService.updateById(permi);
    }

    @RequestMapping("buildAdd")
    @RequiresRoles(value = {"1","2"},logical = Logical.OR)
    public void buildAdd(build b){
        buildIService.insert(b);
    }}
