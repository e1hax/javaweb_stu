package com.stu.web; /**
 * Created by e1hax on 2022-08-23.
 */

import com.alibaba.fastjson.JSON;
import com.stu.pojo.Brand;
import com.stu.servic.BrandService;
import com.stu.servic.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private BrandService service = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求逐日
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //2.将json数据转化为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        //3.sevice调用添加方法
        service.add(brand);

        //4.响应页面请求
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
