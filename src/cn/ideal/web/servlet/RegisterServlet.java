package cn.ideal.web.servlet;

import cn.ideal.dao.UserDao;
import cn.ideal.dao.impl.UserDaoImpl;
import cn.ideal.doamin.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkcode = req.getParameter("checkcode");

        //获取生成的验证码
        HttpSession session = req.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");

        //封装user对象
        User registUser = new User();
        registUser.setUsername(username);
        registUser.setPassword(password);

        //调用UserDao的login方法
        UserDao dao = new UserDaoImpl();
        User user = dao.regist(registUser);

        if (checkcode != null && checkcode.equalsIgnoreCase(checkCode_session)) {
            if (username != null && password != null) {
                //注册成功，存储数据，转发到登录界面
                req.setAttribute("user", user);
                req.getRequestDispatcher("/SuccessServlet").forward(req, resp);
            } else {
                //注册失败，转发到错误页面
                req.getRequestDispatcher("/FailServlet").forward(req, resp);
            }
        } else {
            //注册失败，转发到错误页面
            req.getRequestDispatcher("/FailServlet").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
