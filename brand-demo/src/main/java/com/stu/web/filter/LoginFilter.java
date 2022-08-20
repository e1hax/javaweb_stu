package com.stu.web.filter; /**
 * Created by e1hax on 2022-08-20.
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录验证的过滤器
 */

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req =(HttpServletRequest) request;

        //登录注册相关资源也被拦截了
        //放行与登录注册相关的资源
        String[] urls = {"/login.jsp","loginServlet","/css/","/imgs/","/register.jsp","/registerServlet","/checkCodeServlet"};

        //获取路径
        String url = req.getRequestURL().toString();

        for (String u : urls) {
            if (url .contains(u)) {
                //放行
                chain.doFilter(request, response);
                //结束方法
                return;
            }
        }

        //1 判断session中是否有user
        HttpSession session = req.getSession();

        Object user = session.getAttribute("user");

        // 2. 判断是否为空
        if (user != null) {
            //已登录，放行
            chain.doFilter(request, response);
        }else{
            //未登录，跳转登录页面
            req.setAttribute("login_msg","尚未登录！");
            req.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
