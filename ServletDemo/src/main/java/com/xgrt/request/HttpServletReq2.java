package com.xgrt.request;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/req2")
public class HttpServletReq2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //GET请求逻辑
//        System.out.println("get...");
        //获取所有参数的Map集合
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            //username:xgrt
            System.out.print(key + ":");

            //获取值
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        //根据key获取参数值、数组
        System.out.println("————————————————");
        String[] hobbies = req.getParameterValues("hobby");
        System.out.print("hobby：");
        for (String hobby : hobbies) {
            System.out.print(hobby + " ");
        }
        System.out.println();

        //根据key，获取单个参数值
        System.out.println("————————————————");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        System.out.println("name:" + name);
        System.out.println("password:" + password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //POST请求逻辑
        this.doGet(req,resp);
        /*System.out.println("post...");
        //获取所有参数的Map集合
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            //username:xgrt
            System.out.print(key + ":");

            //获取值
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        //根据key获取参数值、数组
        System.out.println("————————————————");
        String[] hobbies = req.getParameterValues("hobby");
        System.out.print("hobby：");
        for (String hobby : hobbies) {
            System.out.print(hobby + " ");
        }
        System.out.println();

        //根据key，获取单个参数值
        System.out.println("————————————————");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        System.out.println("name" + name);
        System.out.println("password" + password);*/



    }
}
