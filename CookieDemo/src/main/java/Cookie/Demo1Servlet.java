package Cookie;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/cookieDemo1")
public class Demo1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //发送cookie
        //创建cookie对象
//        Cookie cookie=new Cookie("username","X_GRT");

        //解决cookie存不了中文的问题
        String value="鑫哥rt";
        //URL编码
        value= URLEncoder.encode(value,"UTF-8");
        System.out.println("存储数据："+value);

        Cookie cookie=new Cookie("username",value);

        //发送cookie.response
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
