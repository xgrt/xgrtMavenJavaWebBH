package com.xgrt.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter("/hello.jsp")//拦截资源的路径
@WebFilter("/*")
public class FilterDemo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("2、demo2放行前……");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("4、demo2放行后……");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
