package com.tosit.ylxs.web.controller;

import com.google.gson.Gson;
import com.tosit.ylxs.dao.ShoppingDao;
import com.tosit.ylxs.entity.Shopping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by gaoyixiangde on 2016/9/29.
 */
@WebServlet("")
public class indexshoppingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
    PrintWriter out = resp.getWriter();
     int id =Integer.parseInt(req.getParameter("id"));//强转类型
     //   Gson gson = new Gson();
        ShoppingDao shoppingDao = new ShoppingDao();
        Shopping shopping = shoppingDao.selectShoppingById(id);
        req.getSession().setAttribute("id",id);
        resp.sendRedirect("http://localhost:8080/threelevel/shopping.html");
        System.out.println(req.getSession().getAttribute("id"));
    }

}
