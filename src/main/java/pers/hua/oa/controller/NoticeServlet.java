package pers.hua.oa.controller;

import pers.hua.oa.entity.Notice;
import pers.hua.oa.service.NoticeService;
import pers.hua.oa.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/notice/list")
public class NoticeServlet extends HttpServlet {
    private NoticeService noticeService = new NoticeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeId = request.getParameter("eid");
        ResponseUtils resp = null;
        try {
            List<Notice> noticeList = noticeService.getNoticeList(Long.parseLong(employeeId));
            resp = new ResponseUtils().put("list", noticeList);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(resp.toJsonString());
    }
}
