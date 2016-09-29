package com.tosit.ylxs.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/9/29.
 */
@WebServlet("/twoStage/activity")
public class SecondServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
//        通过id查询Article数据
        int id = Integer.parseInt(req.getParameter("id"));
//        把id如session
        req.getSession().setAttribute("id",id);
        resp.sendRedirect("http://localhost:8080/twoStage/activity.html");
    }
}
