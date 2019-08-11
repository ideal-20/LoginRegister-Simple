package cn.ideal.test;

import cn.ideal.dao.UserDao;
import cn.ideal.dao.impl.UserDaoImpl;
import cn.ideal.doamin.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin() {
        User loginuser = new User();
        loginuser.setUsername("admin");
        loginuser.setPassword("admin");


        UserDao dao = new UserDaoImpl();
        User user = dao.login(loginuser);

        System.out.println(user);

    }

}
