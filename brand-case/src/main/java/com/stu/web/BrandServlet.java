package com.stu.web;

import com.alibaba.fastjson.JSON;
import com.stu.pojo.Brand;
import com.stu.pojo.PageBean;
import com.stu.servic.BrandService;
import com.stu.servic.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by e1hax on 2022-08-23.
 */


@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {

    private BrandService service = new BrandServiceImpl();

    /**
     * 查询所有
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.调用sevice的方法
        List<Brand> brands = service.selectAll();

        //2.将List转换为Json
        String jsonString = JSON.toJSONString(brands);
        //3.响应页面请求
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    /**
     * 添加
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求头
        BufferedReader br = req.getReader();
        String params = br.readLine();

        //2.将json数据转化为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        //3.sevice调用添加方法
        service.add(brand);

        //4.响应页面请求
        resp.getWriter().write("success");
    }

    /**
     * 批量删除
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求头  [1,2,3]
        BufferedReader br = req.getReader();
        String params = br.readLine();

        //2.将json数据转化为int 数组
        int[] ids = JSON.parseObject(params, int[].class);

        //3.sevice调用批量删除方法
        service.deleteByIds(ids);

        //4.响应页面请求
        resp.getWriter().write("success");
    }

    /**
     * 分页查询
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接受参数  当前页码，没有显示条数  url?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        //2.  转换为整形
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //3.调用sevice的方法
        PageBean<Brand> pageBean = service.selectByPage(currentPage, pageSize);

        //2.将pageBean对象转换为Json
        String jsonString = JSON.toJSONString(pageBean);

        //3.响应页面请求
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }


    /**
     * 分页条件查询
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接受参数  当前页码，没有显示条数  url?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        //2.  转换为整形
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //接受请求体
        BufferedReader br = req.getReader();
        String params = br.readLine();

        //转换为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        //3.调用sevice的方法
        PageBean<Brand> pageBean = service.selectByPageAndCondition(currentPage, pageSize, brand);

        //2.将pageBean对象转换为Json
        String jsonString = JSON.toJSONString(pageBean);

        //3.响应页面请求
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    /**
     * 删除
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取id
        String _id = req.getParameter("id");
        int id = Integer.parseInt(_id);

        //3.sevice调用删除方法
        service.deleteById(id);

        //4.响应页面请求
        resp.getWriter().write("success");
    }

}
