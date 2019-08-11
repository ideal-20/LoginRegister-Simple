package cn.ideal.dao;

import cn.ideal.doamin.User;

/**
 * 这是针对用户进行操作的接口
 *
 * @author BWH_Steven
 * @version v1.0
 */
public interface UserDao {
    /**
     * 登录方法
     *
     * @param loginUser
     * @return user包含用户全部数据, 没查询到返回null
     */
    public abstract User login(User loginUser);

    /**
     * 注册方法
     *
     * @param registUser
     * @return User
     */
    public abstract User regist(User registUser);
}
