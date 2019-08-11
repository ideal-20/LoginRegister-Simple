package cn.ideal.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class checkCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 128;
        int height = 38;

        //创建一个对象，在内存中存图片
        //TYPE_INT_RG:表示一个图像，它具有合成整数像素的8位RGB颜色分量
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        /*
               美化图片
         */

        //填充背景色
        Graphics g = image.getGraphics();//画笔
        g.setColor(new Color(228, 22, 255));
        //填充一个矩形 ，从0,0点出发
        g.fillRect(0, 0, width, height);

        //画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);

        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        //生成随机角标
        Random random = new Random();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= 4; i++) {
            //随机字符
            int index = random.nextInt(string.length());
            char ch = string.charAt(index);
            sb.append(ch);
            //写验证码
            g.setFont(new Font("consolas", Font.BOLD, 33));
            g.drawString(ch + " ", width / 5 * i, height - 8);
        }
        String checkCode_session = sb.toString();
        req.getSession().setAttribute("checkCode_session", checkCode_session);

        //将图片输出到页面展示
        ImageIO.write(image, "jpg", resp.getOutputStream());

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
