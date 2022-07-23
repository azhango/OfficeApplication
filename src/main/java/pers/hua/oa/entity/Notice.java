package pers.hua.oa.entity;

import java.util.Date;

public class Notice {
    private Long noticeId; //编号
    private Long receiverId; //接收人
    private String content; //内容
    private Date createTime; //创建时间

    public Notice(Long receiverId, String content) {
        this.receiverId = receiverId;
        this.content = content;
        this.createTime = new Date();
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public Long getReceiveId() {
        return receiverId;
    }

    public void setReceiveId(Long receiveId) {
        this.receiverId = receiveId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", receiveId=" + receiverId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
