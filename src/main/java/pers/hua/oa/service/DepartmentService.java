package pers.hua.oa.service;

import pers.hua.oa.entity.Department;
import pers.hua.oa.mapper.DepartmentMapper;
import pers.hua.oa.utils.MybatisUtils;

public class DepartmentService {
    public Department selectById(Long departmentId){
        return (Department)MybatisUtils.executeQuery(sqlSession -> sqlSession.getMapper(DepartmentMapper.class).selectById(departmentId));
    }
}
