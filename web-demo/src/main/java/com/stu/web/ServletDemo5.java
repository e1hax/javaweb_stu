package com.stu.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by e1hax on 2022-08-15.
 */
@WebServlet("/demo5")
public class ServletDemo5 extends MyHttpServlet {

    @Override
    protected void doGet(ServletRequest req, ServletResponse res) {
        System.out.println("get ....");
    }

    @Override
    protected void doPost(ServletRequest req, ServletResponse res) {
        System.out.println("post ....");
    }
}
