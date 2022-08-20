package com.stu.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by e1hax on 2022-08-20.
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //加载资源
        System.out.println("ContextLoaderListener....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //释放资源
    }
}
