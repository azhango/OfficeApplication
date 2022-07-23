package pers.hua.oa.mapper;

import pers.hua.oa.entity.Node;
import pers.hua.oa.utils.MybatisUtils;

import java.util.List;

public class RbacMapper {
    /**
     * 数据库中查找的数据会返回多条数据，用List数组保存
     * @param userId 查找用户权限的userId
     * @return 返回查找到的权限
     */
    public List<Node> selectNodeById(Long userId){
        List list = (List) MybatisUtils.executeQuery(
                sqlSession -> sqlSession.selectList("rbacmapper.selectNodeByUserId",userId)
        );
        return list;
    }
}
