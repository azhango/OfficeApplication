package pers.hua.oa.mapper;

import pers.hua.oa.entity.Notice;

import java.util.List;

public interface NoticeMapper {
    public void insert(Notice notice);

    /**
     * 根据当前接收人查询对应消息
     *
     * @param receiverId 接收人id
     * @return 返回消息
     */
    public List<Notice> selectByReceiverId(Long receiverId);
}
