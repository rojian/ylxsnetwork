package com.tosit.ylxs.web.controller.reception;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 跳转到2级页面
 * Created by Administrator on 2016/9/29.
 */
@WebServlet("*.do")
public class SecondServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
//        通过id查询Article数据
        int id = Integer.parseInt(req.getParameter("id"));
        String number=req.getParameter("number");
        System.out.println(number);
//        把id如session
        req.getSession().setAttribute("id",id);
        resp.sendRedirect("http://localhost:8080/"+number+"/activity.html");
    }
}
