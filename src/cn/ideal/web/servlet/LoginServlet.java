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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
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
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        //调用UserDao的login方法
        UserDao dao = new UserDaoImpl();
        User user = dao.login(loginUser);

        //先判断验证码是否正确，然后，判断用户名密码是否正确
        if (checkCode_session.equalsIgnoreCase(checkcode)) {
            //判断user
            if (user == null) {
                //登陆失败，转发
                req.getRequestDispatcher("/FailServlet").forward(req, resp);
            } else {
                //登陆成功,转发
                req.setAttribute("user",user);
                req.getRequestDispatcher("/SuccessServlet").forward(req, resp);
            }
        } else {
            //登陆失败            //登录失败，转发
            req.getRequestDispatcher("/FailServlet").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
