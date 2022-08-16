package com.stu.web.response; /**
 * Created by e1hax on 2022-08-16.
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1...");

//        //重定向
//        //1. 设置状态码
//        response.setStatus(302);
//        //2. 设置响应头Location
//        response.setHeader("Location","/request-demo/resp2");

        //简化方式完成重定向
        response.sendRedirect("/request-demo/resp2");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
