package pers.hua.oa.mapper;

import pers.hua.oa.entity.Employee;

import java.util.List;
import java.util.Map;

/**
 * 查询员工编号
 */
public interface EmployeeMapper {
    public Employee selectById(Long employeeId);

    public List<Employee> selectByParams(Map params);
}
