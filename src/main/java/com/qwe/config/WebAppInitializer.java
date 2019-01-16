package com.qwe.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;


public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //SpringIOC环境配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    ////DispatcherServlet 环境配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    //DispatchServlet 拦截请求配置
    @Override
    protected String[] getServletMappings() {
        return new String[]{"*.do"};
    }


    /**
     * @param dynamic Servlet 上传文件配置
     */

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic dynamic) {
        //配置上传文件路径
        String filepath = "e:/mvc/uploads";

        //5m
        Long singleMax = (long)(5*Math.pow(2,20));
        //10m
        Long totalMax = (long)(10*Math.pow(2,20));

        //设置上传文件配置
        dynamic.setMultipartConfig(new MultipartConfigElement(filepath,singleMax,totalMax,0));


    }
}
