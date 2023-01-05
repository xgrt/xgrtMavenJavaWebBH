package com.xgrt.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(urlPatterns = "/req1")
public class HttpServletReq1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1. - String getMethod()：请求方式：GET
        String method = req.getMethod();
        System.out.println(method);
//   - String getContextPath()（比较常用）：获取虚拟目录（项目访问路径）：/request-demo
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
//   - StringBuffer getRequestURL()：获取URL（统一资源定位符）：http://localhost:8080/request-demo/req1
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);
//   - String getRequestURI()：获取URI（统一资源标识符）：/request-demo/req1
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
//   - String getQueryString：获取请求参数（GET方式）：username=zhangsan&password=123
        String queryString = req.getQueryString();
        System.out.println(queryString);

//————————————————————
//        获取请求头：User-Agent：浏览器版本
        String agent = req.getHeader("User-Agent");
        System.out.println(agent);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取post请求体：请求参数
        //获取字符输入流
        BufferedReader br=req.getReader();//流会自动关闭
        //读取数据
        String line= URLDecoder.decode(br.readLine(),"UTF-8");//将br读出的数据以UTF-8的格式解码给line
        System.out.println(line);
    }
}
