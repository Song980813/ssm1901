package com.huayu.ssm_1901.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.huayu.ssm_1901.bo.Employee_1;
import com.huayu.ssm_1901.bo.FileUpload;
import com.huayu.ssm_1901.bo.LayuiEntity;
import com.huayu.ssm_1901.bo.MengerTree;
import com.huayu.ssm_1901.pojo.Department;
import com.huayu.ssm_1901.pojo.Employee;
import com.huayu.ssm_1901.pojo.Position;
import com.huayu.ssm_1901.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author dell
 */
@Controller
@RequestMapping("/test")
public class EmployeeServlet<pictureFile> {
    @Autowired
    private EmployeeImpl empService;

    @Autowired
    private PostImpl postService;

    @Autowired
    private IService<Department> departService;
    static final Logger logger = LogManager.getLogger(EmployeeServlet.class.getName());

    @ResponseBody
    @RequiresRoles(value = {"1","2","3","4","5"},logical = Logical.OR)
    public LayuiEntity selectLay(Integer page,Integer limit,Employee empl){
        Wrapper wrapper= new EntityWrapper<>();
        if(StringUtils.isEmpty(empl)){
           wrapper=null;
        }else{
            if(!StringUtils.isEmpty(empl.getName())){
                 wrapper.eq("name",empl.getName());
            }
            if(empl.getDeptId()!=null){
                wrapper.eq("dept_id",empl.getDeptId());
            }
        }
        Page page1=new Page(page,limit);
        Page p=empService.selectPage(page1,wrapper);
        String sr=String.valueOf(p.getTotal());
        List<Employee> list=p.getRecords();
        List<Employee_1> list2=new ArrayList<>();
        for(Employee employee:list){
            Employee_1 emp=new Employee_1();
            emp.setId(employee.getId());
            emp.setName(employee.getName());
            emp.setAge(employee.getAge());
            emp.setSex(employee.getSex());
            List<Position> li= postService.queryPost1(employee.getPostId());
            StringBuffer sb=new StringBuffer();
            for(Position position:li){
                sb.append(position.getPname()).append(",");
            }
            String str=sb.toString().substring(0,sb.toString().lastIndexOf(","));
            emp.setPostId(str);
            Department department= departService.selectById(employee.getDeptId());
            emp.setDeptId(department.getDname());
            emp.setSalary(employee.getSalary());
            emp.setIdentificationPhoto(employee.getIdentificationPhoto());
            list2.add(emp);
        }
        LayuiEntity layuiEntity= new LayuiEntity();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("查询成功");
        layuiEntity.setCount(Integer.parseInt(sr));
        layuiEntity.setData(list2);
        logger.info("员工信息查询成功");
        return layuiEntity;

    }

    @RequestMapping("/queryEmp2")
    @RequiresRoles(value = {"1","2","3","4","5"},logical = Logical.OR)
    public String queryEmpOne2(Integer id,Model model){
        Employee emp= empService.selectById(id);
        List<Position> list=postService.selectList(null);
        List<Department> list1=departService.selectList(null);
        model.addAttribute("emp",emp);
        model.addAttribute("list",list);
        model.addAttribute("list1",list1);

        return "/layuiTest/empLoyeeUpdate.html";
    }
    @RequestMapping("/save")
    @RequiresRoles(value = {"1","2","3"},logical = Logical.OR)
    public String save(Employee employee) throws IOException {
        String pwd= employee.getPassword();
        Integer user=employee.getUsernumber();
        Object result=new SimpleHash("MD5",pwd,user,1024);
        employee.setPassword((String) result);
        empService.insert(employee);
        return "/layuiTest/employee.html";
    }
    @RequestMapping("/updateOne")
    @RequiresRoles(value = {"1","2","3","4"},logical = Logical.OR)
    public String updateOne(Employee employee,@RequestParam("picture") MultipartFile picture, HttpServletRequest request) throws IOException {
        // 图片上传
        // 设置图片名称，不能重复，可以使用uuid
        String picName = UUID.randomUUID().toString();
        // 获取文件名
        String oriName = picture.getOriginalFilename();
        // 获取图片后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));
        // 开始上传
        String filepath=request.getServletContext().getRealPath("/");
        String file=new File(filepath).getParent()+"\\upload";
        File  file1=new File(file);
        if(!file1.exists()){
            file1.mkdir();
        }
        picture.transferTo(new File(file,picName+extName));
        employee.setIdentificationPhoto("upload/"+picName+extName);
        empService.updateById(employee);
        return "redirect:/test/queryEmp.do";
    }

    @ResponseBody
    @RequestMapping("/delete")
    @RequiresRoles(value = {"1","2","3"},logical = Logical.OR)
    public String delete(Integer id, HttpServletResponse response)throws IOException{
        Boolean i=empService.deleteById(id);
        if (i){
            System.out.println("删除成功：+yes");
            return "yes";
        }
        System.out.println("删除丝毫不I");
        return "no";
    }

    @RequestMapping("/sousuo")
    @RequiresRoles(value = {"1","2","3","4","5"},logical = Logical.OR)
    public String souSuo(Employee employee,Model model){
        List<Employee> list=empService.query(employee);
        List<Employee_1> list2=new ArrayList<>();
        for(Employee empl:list){
            Employee_1 emp=new Employee_1();
            emp.setId(empl.getId());
            emp.setName(empl.getName());
            emp.setAge(empl.getAge());
            emp.setSex(empl.getSex());
            List<Position> li= postService.queryPost1(empl.getPostId());
            StringBuffer sb=new StringBuffer();
            for(Position position:li){
                sb.append(position.getPname()).append(",");
            }
            String str=sb.toString().substring(0,sb.toString().lastIndexOf(","));
            emp.setPostId(str);
            Department department= departService.selectById(empl.getDeptId());
            emp.setDeptId(department.getDname());
            emp.setSalary(empl.getSalary());
            emp.setIdentificationPhoto(empl.getIdentificationPhoto());
            list2.add(emp);
        }
        model.addAttribute("list",list2);
        return "empView";
    }
    @RequestMapping("photoadd")
    @ResponseBody
    public FileUpload photoAdd(@RequestParam("file") MultipartFile picture,HttpServletRequest request) throws IOException {
        // 图片上传
        // 设置图片名称，不能重复，可以使用uuid
        String picName = UUID.randomUUID().toString();
        // 获取文件名
        String oriName = picture.getOriginalFilename();
        // 获取图片后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));
        // 开始上传
        String filepath=request.getServletContext().getRealPath("/");
        String file=new File(filepath).getParent()+"\\upload";
        File  file1=new File(file);
        if(!file1.exists()){
            file1.mkdir();
        }
        picture.transferTo(new File(file,picName+extName));
        FileUpload fileUpload=new FileUpload();
        fileUpload.setCode("0");
        fileUpload.setMsg("添加成功");
        fileUpload.setData("/upload/"+picName+extName);
        return fileUpload;
    }
    @RequestMapping("deletes")
    @RequiresRoles(value = {"1","2","3"},logical = Logical.OR)
    public FileUpload deletes(String []ids){
        List list=Arrays.asList(ids);
        Boolean b=empService.deleteBatchIds(list);
        FileUpload fileUpload=new FileUpload();
        if(b==true){
            fileUpload.setCode("0");
        }else{
            fileUpload.setCode("1");
        }
        return fileUpload;
    }

    @RequestMapping("magarId")
    @ResponseBody
    public List<MengerTree> mangerId(){
      return empService.mengerQery(-1);
    }
}
