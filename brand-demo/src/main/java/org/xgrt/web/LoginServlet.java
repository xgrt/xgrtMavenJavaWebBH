package org.xgrt.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.xgrt.pojo.User;
import org.xgrt.service.UserService;

import java.io.IOException;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //获取复选框数据
        String remember = request.getParameter("remember");

        //调用service查询
        User user = service.login(username, password);

        //判断
        if (user != null) {
            //登录成功，跳转到查询所有的brand的Servlet

            //判断用户是否勾选记住我
            if ("1".equals(remember)) {
                //勾选了，发送Cookie

                //创建Cookie对象
                Cookie usernameCookie = new Cookie("username", username);
                Cookie passwordCookie = new Cookie("password", password);

                //设置Cookie的存活时间为7天
                int cookieMaxAge = 60 * 60 * 24 * 7;
                usernameCookie.setMaxAge(cookieMaxAge);
                passwordCookie.setMaxAge(cookieMaxAge);

                //发送
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }

            //将登录成功后的user对象存储到session中
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/selectAllServlet");

        } else {
            //登录失败

            //存储错误信息到request
            request.setAttribute("login_msg", "用户名或密码错误");

            //跳转到login.jsp页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
