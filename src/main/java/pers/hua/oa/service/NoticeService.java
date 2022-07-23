package pers.hua.oa.service;

import pers.hua.oa.entity.Notice;
import pers.hua.oa.mapper.NoticeMapper;
import pers.hua.oa.utils.MybatisUtils;

import java.util.List;

public class NoticeService {
    public List<Notice> getNoticeList(Long receiverId) {
        return (List) MybatisUtils.executeQuery(sqlSession -> {
            NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
            return noticeMapper.selectByReceiverId(receiverId);
        });
    }
}
