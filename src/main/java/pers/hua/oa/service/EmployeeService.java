package pers.hua.oa.service;

import pers.hua.oa.entity.Employee;
import pers.hua.oa.mapper.EmployeeMapper;
import pers.hua.oa.utils.MybatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 员工服务
 */
public class EmployeeService {
    public Employee selectById(Long employeeId) {
        Employee employee = (Employee) MybatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            return mapper.selectById(employeeId);
        });
        return employee;
    }

    /**
     * 上级员工
     */
    public Employee selectLeader(Long employeeId) {
        Employee l = (Employee) MybatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.selectById(employeeId);
            Map params = new HashMap();
            //返回上级本人
            Employee leader = null;
            if (employee.getLevel() < 7) {
                //查询部门经理
                params.put("level", 7);
                params.put("department", employee.getDepartmentId());
                List<Employee> employees = mapper.selectByParams(params);
                leader = employees.get(0);
            } else if (employee.getLevel() == 7) {
                //查询总经理
                params.put("level", 8);
                List<Employee> employees = mapper.selectByParams(params);
                leader = employees.get(0);
            } else if (employee.getLevel() == 8) {
                //返回自己
                leader = employee;
            }
            return leader;
        });
        return l;
    }
}
