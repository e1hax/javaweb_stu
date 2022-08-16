package com.stu.web.request; /**
 * Created by e1hax on 2022-08-16.
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/req3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 解决POST中文乱码，   getReader()
//        request.setCharacterEncoding("UTF-8"); //设置字符输入流的编码

        //2.获取username
        String username = request.getParameter("username");
        System.out.println(username);

        //3.解决GET中文乱码， POST通用
        //乱码原因：tomcat进行URL解码，默认字符集为ISO_8859_1
        /*
            //3.1先对乱码数据进行编码：转为字节数组
            byte[] bytes = username. getBytes(standardcharsets.ISO_8859_1);
            //3.2字节数组解码
            username = new String(bytes, StandardCharsets.UTF_8);*/

        new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        System.out.println(username);


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
