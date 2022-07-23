package pers.hua.oa.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pers.hua.oa.entity.User;
import pers.hua.oa.service.UserService;
import pers.hua.oa.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hua
 */
@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        //接收用户输入
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //调用业务逻辑
        ResponseUtils resp = null;
        try {
            User user = userService.checkLogin(username, password);
            user.setPassword(null);
            user.setSalt(null);
            //处理结果编码,0代表处理成功,非0代表处理失败
            resp = new ResponseUtils().put("user", user);
        }catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        //返回JSON结果
        response.getWriter().println(resp.toJsonString());
    }
}
