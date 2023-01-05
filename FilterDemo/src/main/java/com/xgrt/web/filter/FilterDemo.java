package com.xgrt.web.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")//配置拦截路径
public class FilterDemo implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //放行前，对 request数据进行处理
        System.out.println("1、FilterDemo……doFilter放行前……");

        //放行（否则会一直卡在这里）
        filterChain.doFilter(servletRequest,servletResponse);


        //放行后，对 response数据进行处理
        System.out.println("5、FilterDemo……doFilter放行后……");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
