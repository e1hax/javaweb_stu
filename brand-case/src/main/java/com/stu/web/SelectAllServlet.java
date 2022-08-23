package com.stu.web;


import com.alibaba.fastjson.JSON;
import com.stu.pojo.Brand;
import com.stu.servic.BrandService;
import com.stu.servic.impl.BrandServiceImpl;

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
    private BrandService service = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.调用sevice的方法
        List<Brand> brands = service.selectAll();

        //2.将List转换为Json
        String jsonString = JSON.toJSONString(brands).toString();

        //3.响应页面请求
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
