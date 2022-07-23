package pers.hua.oa.service;

import pers.hua.oa.entity.Node;
import pers.hua.oa.mapper.RbacMapper;

import java.util.List;

/**
 * 根据传入userId找到对应权限
 */
public class RbacService {
    private RbacMapper rbacMapper = new RbacMapper();
    public List<Node> selectNodeByUserId(Long userId){
        return rbacMapper.selectNodeById(userId);
    }
}
