package com.xgrt.request;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/req4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post：解决中文乱码问题
        request.setCharacterEncoding("UTF-8");//设置字符输入流的编码
        String name = request.getParameter("name");
        System.out.println(name);

        //get：解决中文乱码问题
        //get:获取参数的方式：getQueryString
        //乱码原因：URL解码方式默认是ISO-8859-1
//          先对乱码数据进行编码：转为字节数组
        byte[] bytes = name.getBytes(StandardCharsets.ISO_8859_1);
//          字节数据解码
        name = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(name);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
