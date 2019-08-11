package cn.ideal.web.servlet;

import cn.ideal.doamin.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取request域中共享的user对象
        User user = (User) req.getAttribute("user");

        if (user != null) {
            //设置编码
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charser=UTF-8");
            //输出
            resp.getWriter().write("登陆/注册：" + user.getUsername() + "成功! —— This page is just for test ! <br>");
            resp.getWriter().write("<a href='login.html'>返回登录界面</a>");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
