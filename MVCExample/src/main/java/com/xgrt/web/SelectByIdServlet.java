package com.xgrt.web;

import com.xgrt.pojo.Brand;
import com.xgrt.service.BrandService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/selectById")
public class SelectByIdServlet extends HttpServlet {
    private BrandService service=new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //接收id
        String id = request.getParameter("id");
        //调用service查询
        Brand brand = service.selectById(Integer.parseInt(id));
        //存储到request中
        request.setAttribute("brand",brand);
        //转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
