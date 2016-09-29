package com.tosit.ylxs.web.controller;

import com.google.gson.Gson;
import com.tosit.ylxs.entity.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 转发器
 * 把id写入session
 * Created by Administrator on 2016/9/26.
 */
@WebServlet("/threeLevel/activity/*")
public class IndexNextServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
//        通过id查询Article数据
        int id = Integer.parseInt(req.getParameter("id"));
//        把id如session
        req.getSession().setAttribute("id",id);
        resp.sendRedirect("http://localhost:8080/threelevel/activity.html");
        System.out.println(req.getSession().getAttribute("id"));
    }

}
