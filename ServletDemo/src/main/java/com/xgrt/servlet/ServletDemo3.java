package com.xgrt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Servlet方法介绍
 */
@WebServlet(urlPatterns = "/demo3",loadOnStartup = 1)
public class ServletDemo3 implements Servlet {
    private ServletConfig config;

    /**
     * 初始化方法
     * 1. 调用时机：默认情况下，Servlet被第一次访问时调用
     *      * loadOnStartup:
     * 2. 调用次数：1次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config=servletConfig;
        System.out.println("ServletDemo3的init()方法被调用");
    }

    /**
     * 提供服务
     * 1. 调用时机：每一次Servlet被访问时调用
     * 2. 调用次数：多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("ServletDemo3的service()方法被调用");
    }

    /**
     * 销毁方法
     * 1. 调用时机：内存释放或者服务器被关闭的时候。Servlet对象会被销毁，调用
     * 2. 调用次数：1次
     */
    @Override
    public void destroy() {
        System.out.println("ServletDemo3的destroy()方法被调用");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    //返回init()方法里的servletConfig对象
    /*
    无法直接调用：
        将servletConfig变成类的成员变量
     */
    @Override
    public String getServletInfo() {
        return null;
    }
}
