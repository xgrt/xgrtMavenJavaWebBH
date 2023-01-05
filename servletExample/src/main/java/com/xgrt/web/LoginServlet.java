package com.xgrt.web;

import com.xgrt.mapper.UserMapper;
import com.xgrt.pojo.User;


import com.xgrt.util.SqlSessionFactoryUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收用户名和密码
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        //调用MyBatis完成查询
        //  获取SqlSessionFactory对象
        /*String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);*/
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        //获取 SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用方法
        User user = userMapper.select(userName, password);

        //释放资源
        sqlSession.close();

        //湖区字符输出流，并设置content-type
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //判断user是否为null（空）
        if (user!=null)
        {
            //登录成功
            writer.write("登录成功");
        }
        else
        {
            //登录失败
            writer.write("登录失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
