package com.xgrt.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字节数据，设置字节数据的响应体
 */

@WebServlet(urlPatterns = "/resp4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp4……");

        //读取文件
        FileInputStream fis = new FileInputStream("f://动漫游戏收集//无水印//5.jpg");

        //获取response字节输出流
        ServletOutputStream os = response.getOutputStream();

        //完成流的copy（复制）
        /*
        byte[] buff = new byte[1024];
        int len = 0;

        while ((len = fis.read(buff)) != -1)
        {
            os.write(buff,0,len);
        }
        */

        //使用Apache公司的commons-io包的IOUtils类来简化操作
        //已经通过配置pom.xml来导包
        IOUtils.copy(fis,os);
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
