package com.stu.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by e1hax on 2022-08-20.
 */
@WebServlet("/axiosServlet")
public class AxiosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get....");
        //1.  接受数据
        String username = req.getParameter("username");
        System.out.println(username);

        //2. 相应数据
        resp.getWriter().write("hello ajax");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post....");
        super.doGet(req, resp);
    }
}
