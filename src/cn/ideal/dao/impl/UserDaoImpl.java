package cn.ideal.dao.impl;

import cn.ideal.dao.UserDao;
import cn.ideal.doamin.User;
import cn.ideal.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {

    //声明JDBCTemplate对象共用，封装数据库连接池
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User login(User loginUser) {
        try {
            //1.编写sql
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            //2.调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            System.out.println("null");
            return null;

        }
    }

    @Override
    public User regist(User registUser) {
        String username = registUser.getUsername();
        String password = registUser.getPassword();

        String sql = "INSERT INTO user VALUES(NULL,?,?)";
        template.update(sql,username,password);
        return registUser;
    }
}
