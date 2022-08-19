package com.stu.web; /**
 * Created by e1hax on 2022-08-19.
 */

import com.stu.pojo.User;
import com.stu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取填写的验证码
        String checkCode = request.getParameter("checkCode");

        //获取程序生成的session
        HttpSession session = request.getSession();
        String checkCodeGen =(String) session.getAttribute("checkCodeGen");

        //2. 封装为User
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (!checkCodeGen.equalsIgnoreCase(checkCode)) {
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            //不允许注册
            return;
        }

        //3.调用Service注册
        boolean flag = service.register(user);
        if (flag == true) {
            request.setAttribute("register_msg","注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else{
            request.setAttribute("register_msg","用户已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
