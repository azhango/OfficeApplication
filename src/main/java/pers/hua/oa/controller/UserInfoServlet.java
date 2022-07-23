package pers.hua.oa.controller;

import pers.hua.oa.entity.Department;
import pers.hua.oa.entity.Employee;
import pers.hua.oa.entity.Node;
import pers.hua.oa.service.DepartmentService;
import pers.hua.oa.service.EmployeeService;
import pers.hua.oa.service.RbacService;
import pers.hua.oa.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hua
 * 获取与用户相关的信息
 */
@WebServlet("/api/user_info")
public class UserInfoServlet extends HttpServlet {
    private RbacService rbacService = new RbacService();
    private EmployeeService employeeService = new EmployeeService();
    private DepartmentService departmentService = new DepartmentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid"); //对应用户编号
        String eid = request.getParameter("eid"); //员工编号
        //获取到用户功能
        List<Node> nodes = rbacService.selectNodeByUserId(Long.parseLong(uid));
        List<Map> treeList = new ArrayList<>(); // 存储最终数据，类型为Map
        Map moudel = null;
        for (Node node : nodes) {
            if (node.getNodeType() == 1) {
                moudel = new LinkedHashMap();
                moudel.put("node", node);
                moudel.put("children", new ArrayList());
                treeList.add(moudel);
            } else if (node.getNodeType() == 2) {
                List children = (List) moudel.get("children");
                children.add(node);
            }
        }
        Employee employee = employeeService.selectById(Long.parseLong(eid));
        Department department = departmentService.selectById(employee.getDepartmentId());
        String json = new ResponseUtils()
                .put("nodeList", treeList).put("employee",employee).put("department",department).toJsonString();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
