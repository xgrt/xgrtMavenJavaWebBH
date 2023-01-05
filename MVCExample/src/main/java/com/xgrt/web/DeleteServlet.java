package com.xgrt.web;

import com.xgrt.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/deleteServlet")
public class DeleteServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理post的中文乱码问题
        request.setCharacterEncoding("UTF-8");

        //接收表单提交的数据，封装为brand对象
        String id=request.getParameter("id");

        //调用service 完成添加
        service.delete(Integer.parseInt(id));

        //转发到查询所有的servlet
        request.getRequestDispatcher("/selectAllServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
