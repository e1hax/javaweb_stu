package com.stu.web;

import com.alibaba.fastjson.JSON;
import com.stu.pojo.Brand;
import com.stu.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by e1hax on 2022-08-20.
 */
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 调用select方法
        List<Brand> brands = service.selectAll();

        //2. 将brands 转换为json
        String jsonString = JSON.toJSONString(brands).toString();

        //3. 响应
        resp.setContentType("text/json;charset=UTF-8");
        resp.getWriter().write(jsonString);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
