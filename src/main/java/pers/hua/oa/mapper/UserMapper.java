package pers.hua.oa.mapper;

import pers.hua.oa.entity.User;
import pers.hua.oa.utils.MybatisUtils;

public class UserMapper {
    /**
     * 根据前台输入用户名查找数据，如果数据库存在用户则返回用户数据，不存在该用户则返回null
     *
     * @param username 前台输入用户名
     * @return 返回用户数据
     */
    public User selectByUsername(String username) {
        User user = (User) MybatisUtils.executeQuery(
                sqlSession -> sqlSession.selectOne("usermapper.selectByUsername", username));
        return user;
    }
}
