package com.stu.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by e1hax on 2022-08-16.
 */
@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // String getMethod():获取请求方式：GET
        String method = req.getMethod();
        System.out.println(method);

        //String getContextPath()):获取虚拟目录（项目访问路径）:/request-demo
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        //StringBuffer getRequestURL():获取URL(统一资源定位符）:http://localhost:8080/request-demo/req1
        StringBuffer url = req.getRequestURL();
        System.out.println(url);

        // String getRequestURI():获取URI(统一资源标识符）:/request-demo/req1
        String uri = req.getRequestURI();
        System.out.println(uri);

        //String getQueryString0:获取请求参数（GET方式）:username=zhangsan&password=123
        String queryString = req.getQueryString();
        System.out.println(queryString);

        //获取请求头：user-agent  浏览器版本信息
        String header = req.getHeader("User-Agent");
        System.out.println(header);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取post请求体参数

        //1.获取字符输入流
        BufferedReader br = req.getReader();

        //2.读取数据
        String line = br.readLine();
        System.out.println(line);

    }
}
