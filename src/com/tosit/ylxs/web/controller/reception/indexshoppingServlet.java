package com.tosit.ylxs.web.controller.reception;

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
@WebServlet("*.pi")
public class indexshoppingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
    PrintWriter out = resp.getWriter();


        ShoppingDao shoppingDao = new ShoppingDao();
        List<Shopping> shopping = shoppingDao.selectShoppingAllshop();




        Gson gson = new Gson();
        String jsonobject=gson.toJson(shopping);
        out.print(jsonobject);
        out.flush();
    }
}
