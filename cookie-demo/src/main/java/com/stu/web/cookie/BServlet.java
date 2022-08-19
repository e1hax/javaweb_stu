package com.stu.web.cookie; /**
 * Created by e1hax on 2022-08-19.
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/bServlet")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cookie

        //1. 获取Cookie数组
        Cookie[] cookies = request.getCookies();

        //2. 遍历数组
        for (Cookie cookie :cookies) {
            String name = cookie.getName();
            if ("username".equals(name)) {
                String value = cookie.getValue();
                //URL解码
                value = URLDecoder.decode(value);
                System.out.println(name+":"+value);

                break;
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
