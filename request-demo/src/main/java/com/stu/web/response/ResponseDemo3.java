package com.stu.web.response;
/**
 * Created by e1hax on 2022-08-16.
 * Response响应字符数据
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp3...");

        response.setContentType("text/html;charset=utf8");
        //1. 获取字符输出流
        PrintWriter writer = response.getWriter();
        //设置content-type
        //response.setHeader("content-type","text/html");
        writer.write("你好");
        writer.write("<h1>aaa</h1>");

        //细节：流不需要关闭
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
