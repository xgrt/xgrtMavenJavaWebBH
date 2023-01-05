package Cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(urlPatterns = "/cookieDemo2")
public class Demo2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cookie
        //获取Cookie数组
        Cookie[] cookies = request.getCookies();

        //遍历数组
        for (Cookie cookie : cookies) {
            //获取数据
            String name = cookie.getName();
            if ("username".equals(name))
            {
                String value = cookie.getValue();
                //URL解码
                value= URLDecoder.decode(value,"UTF-8");
                System.out.println("name:"+value);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
