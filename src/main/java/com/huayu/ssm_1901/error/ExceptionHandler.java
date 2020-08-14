package com.huayu.ssm_1901.error;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //1、判断是哪一种异常
        String msg="";
        if(e instanceof MyExecption){
            MyExecption myExecption=(MyExecption)e;
            msg=myExecption.getMsg();
        }
        //2、发送邮件和短信通知到相关人员

        //3、跳转到友好的页面，并展示描述信息
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("error",msg);
        modelAndView.setViewName("/error/500.html");
        return modelAndView;
    }
}