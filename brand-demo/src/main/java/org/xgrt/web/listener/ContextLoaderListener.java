package org.xgrt.web.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        //加载资源
        System.out.println("ContextLoaderListener……");
    }

    public void contextDestroyed(ServletContextEvent sce)
    {
        //释放资源
    }
}
