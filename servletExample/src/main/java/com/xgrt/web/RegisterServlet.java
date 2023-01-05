package com.xgrt.web;

import com.xgrt.mapper.UserMapper;
import com.xgrt.util.SqlSessionFactoryUtils;
import com.xgrt.pojo.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收用户数据
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        //封装用户对象
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);

        //调用mapper 根据用户名查询用户对象
        //  获取SqlSessionFactory对象
        /*String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);*/
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        //获取 SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用方法
        User selectedUser = userMapper.selectByUserName(userName);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //判断用户对象是否为null
        if (selectedUser==null)
        {
            //用户名不存在，添加用户
            userMapper.add(user);

            //提交事务
            sqlSession.commit();

            //添加完毕，给出提示信息
            writer.write("注册成功");
            //释放资源
            sqlSession.close();
        }
        else
        {
            //用户名已存在，给出提示信息
            writer.write("用户名已存在");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
