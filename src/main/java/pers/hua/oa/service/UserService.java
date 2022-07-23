package pers.hua.oa.service;

import org.apache.commons.codec.digest.DigestUtils;
import pers.hua.oa.entity.User;
import pers.hua.oa.mapper.UserMapper;
import pers.hua.oa.service.exception.LoginException;
import pers.hua.oa.utils.Md5Utils;

/**
 * 登录业务逻辑
 */
public class UserService {
    private UserMapper userMapper = new UserMapper();

    /**
     * 根据前台输入进行登录效验
     *
     * @param username 前台输入用户名
     * @param password 前台输入密码
     * @return 校验通过后，包含用户对应数据的User实体类
     * @throws LoginException 用户登录异常
     */
    public User checkLogin(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            throw new LoginException("用户错误或不存在");
        }
        String md5 = Md5Utils.md5Digest(password, user.getSalt());
        if (!md5.equals(user.getPassword())) {
            throw new LoginException("密码错误");
        }
        return user;
    }
}
