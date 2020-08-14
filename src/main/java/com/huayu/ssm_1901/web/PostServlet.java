package com.huayu.ssm_1901.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.huayu.ssm_1901.bo.LayuiEntity;
import com.huayu.ssm_1901.error.MyExecption;
import com.huayu.ssm_1901.pojo.Employee;
import com.huayu.ssm_1901.pojo.Position;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author dell
 */
@Controller
@RequestMapping("/PostServlet")
public class PostServlet {
    @Autowired
    private IService<Position> postImpl;
    @Autowired
    private IService<Employee> userService;

    static final Logger logger = LogManager.getLogger(PostServlet.class.getName());

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Position> queryAll(){
        logger.info("角色查询启动");
        return postImpl.selectList(null);
    }
    @RequestMapping("/queryA")
    @ResponseBody
    @RequiresRoles(value = {"1","2","3","4","5"},logical = Logical.OR)
    public LayuiEntity queryA(){
        List list2=postImpl.selectList(null);
        LayuiEntity layuiEntity= new LayuiEntity();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("查询成功");
        layuiEntity.setCount(list2.size());
        layuiEntity.setData(list2);
        return layuiEntity;
    }

    @RequestMapping("/queryone")
    @ResponseBody
    public String queryOne(Integer id, Model model){
        Position position=postImpl.selectById(id);
        model.addAttribute("post",position);
        return "/layuiTest/positionUpdate.html";
    }
    @RequestMapping("/login")
    public String  login(String userNum, String pwd, HttpServletRequest request) throws MyExecption {
        UsernamePasswordToken token=new UsernamePasswordToken(userNum,pwd);
        Subject subject=  SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            throw new MyExecption("此用户不存在");
        } catch (IncorrectCredentialsException e){
            throw new MyExecption("密码错误");
        }

        EntityWrapper  wrapper=new EntityWrapper<>();
        wrapper.eq("usernumber",userNum);
        Employee userInfo1=userService.selectOne(wrapper);
        HttpSession session= request.getSession();
        session.setAttribute("user",userInfo1.getUsernumber());
        session.setAttribute("pwd",userInfo1.getPassword());
        return "redirect:/layuiTest/homePage.html";
    }

    @RequestMapping("positionUpdate")
    @RequiresRoles(value = {"1","2","3"},logical = Logical.OR)
    public void update(Position position){
         postImpl.updateById(position);
    }
    @RequestMapping("positionAdd")
    @RequiresRoles(value = {"1","2","3"},logical = Logical.OR)
    public void postionAdd(Position position){
        postImpl.insert(position);
    }
}
