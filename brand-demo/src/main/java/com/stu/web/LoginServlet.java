package com.stu.web; /**
 * Created by e1hax on 2022-08-19.
 */

import com.stu.pojo.User;
import com.stu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名，密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 获取复选框状态
        String remember = request.getParameter("remember");

        //2. 调用 login
        User user = service.login(username, password);

        //3.判断user
        if (user != null) {
            //登录成功

            //获取session对象
            HttpSession session = request.getSession();
            //存储对象
            session.setAttribute("user",user);

            //判断用户是否勾选记住我
            if ("1".equals(remember)) {
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);

                //将Cookie设置保存时间
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);

                //发送Cookie.response
                response.addCookie(c_username);
                response.addCookie(c_password);
            }

            String contextPath = request.getContextPath();
            //重定向
            response.sendRedirect(contextPath+"/selectAllServlet");
        }else{
            //登录失败
            //提示用户名或密码错误
            request.setAttribute("login_msg","用户名或密码错误");
            //转发
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
