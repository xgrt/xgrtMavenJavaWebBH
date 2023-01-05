package org.xgrt.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.xgrt.pojo.User;
import org.xgrt.service.UserService;

import java.io.IOException;

@WebServlet(urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //获取衣服输入的验证码
        String checkCode = request.getParameter("checkCode");

        //获取程序生成的验证码
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        //比对
        if (!checkCodeGen.equalsIgnoreCase(checkCode))
        {
            //不允许注册
            request.setAttribute("checkCode_msg", "验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }

        User user = new User();
        user.setUserName(username);
        user.setPassword(password);

        //调用service 注册
        boolean flag = service.register(user);

        //判断注册成功与否
        if (flag) {
            //注册功能，跳转登录页面
            request.setAttribute("request_msg", "注册成功，请登录。");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            //注册失败，跳转到注册页面
            request.setAttribute("request_msg", "用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
