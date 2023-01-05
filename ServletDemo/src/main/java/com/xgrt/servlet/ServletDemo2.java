package com.xgrt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Servlet生命周期
 */
@WebServlet(urlPatterns = "/demo2",loadOnStartup = 1)
public class ServletDemo2 implements Servlet {

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
        System.out.println("ServletDemo2的init()方法被调用");
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
        System.out.println("ServletDemo2的service()方法被调用");
    }

    /**
     * 销毁方法
     * 1. 调用时机：内存释放或者服务器被关闭的时候。Servlet对象会被销毁，调用
     * 2. 调用次数：1次
     */
    @Override
    public void destroy() {
        System.out.println("ServletDemo2的destroy()方法被调用");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }



    @Override
    public String getServletInfo() {
        return null;
    }
}
