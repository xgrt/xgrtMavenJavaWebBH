package com.xgrt.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字符数据，设置字符数据的响应体
 */

@WebServlet(urlPatterns = "/resp3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp3……");

        //setContentType设置头
        //解决输入到html的中文乱码，这里的setContentType在设置流的编码
        response.setContentType("text/html;charset=UTF-8");

        //获取字符输出流
        PrintWriter writer = response.getWriter();
        //设置content-type，令其可以解析HTML标签
        response.setHeader("content-type","text/html");

        writer.write("鑫哥rt666");
        writer.write("<h1>鑫哥rt</h1>");

        //细节：流不需要关闭
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
