package com.tosit.ylxs.web.controller.backstage;

import com.tosit.ylxs.dao.UserDao;
import com.tosit.ylxs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/9/30.
 */
@WebServlet("/backstage/changePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String oldpassword = req.getParameter("oldpassword");
        String newpassword = req.getParameter("newpassword");
        String repassword = req.getParameter("repassword");
        User user = (User) req.getSession().getAttribute("user");
        if (oldpassword == null) {
            oldpassword = "";
        }
        if (user.getPassword().equals(oldpassword)) {
            if (newpassword != null && newpassword != null && !newpassword.equals("") && !repassword.equals("")) {
                if (newpassword.equals(repassword)) {
                    user.setPassword(newpassword);
                    UserDao userDao = new UserDao();
                    boolean isOk = userDao.upUser(user);
                    if (isOk) {
                        req.getSession().setAttribute("user", user);
                        out.print("修改成功");
                    }
                }else{
                    out.print("输入密码不正确");
                }
            }{
                out.print("输入密码不能为空");
            }
        }else {
            out.print("两次输入密码不对");
        }
    }
}
