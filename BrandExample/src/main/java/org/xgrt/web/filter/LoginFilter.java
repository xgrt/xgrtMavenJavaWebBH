package org.xgrt.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;

/**
 * 登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        //判断session中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        System.out.println(user);

        //判断user是否为null
        if (user != null) {
            //已经登录
            //放行
            chain.doFilter(request, response);
        }
        else
        {
            //未登录，存储提示信息，跳转到登录界面
            req.setAttribute("login_msg","您尚未登录！");
            req.getRequestDispatcher("/login.jsp").forward(req,response);
        }


    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
}
