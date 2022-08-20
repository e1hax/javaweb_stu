package com.stu.web; /**
 * Created by e1hax on 2022-08-20.
 */

import com.alibaba.fastjson.JSON;
import com.stu.pojo.Brand;
import com.stu.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取请求体
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //2. 将JSON转换为Java对象
        Brand brand = JSON.parseObject(params, Brand.class);

        //3. 调用service 完成添加
        service.add(brand);

        //4 响应标签
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
