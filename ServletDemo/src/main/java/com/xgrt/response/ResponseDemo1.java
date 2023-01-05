package com.xgrt.response;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1……");

        //重定向
        //设置响应状态码
//        response.setStatus(302);
//        //设置响应头
//        //location不区分大小写
//        //第二个参数也可以直接写"resp2"
//        /*
//         第二个参数不能写成
//         "ServletDemo/resp2"
//         或是"/ServletDemo//resp2"
//         或是"//ServletDemo/resp2"
//         或是"//ServletDemo//resp2"
//         或是"/resp2"
//         或是"///resp2"
//         */
//        response.setHeader("Location","/ServletDemo/resp2");

        //简化方式完成重定向：路径问题同上
        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/resp2");
//        response.sendRedirect("https://www.bilibili.com");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
