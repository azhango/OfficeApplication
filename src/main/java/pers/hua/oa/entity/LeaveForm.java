package pers.hua.oa.entity;

import java.util.Date;

public class LeaveForm {
    private Long formId; //请假编号
    private Long employeeId; //员工编号
    private Integer formType; //请假类型 1-事假 2-病假 3-工伤假 4-婚假 5-产假 6-丧假
    private Date startTime; // 请假开始时间
    private Date endTime; // 请假结束时间
    private String reason; // 请假事由
    private Date createTime; // 创建时间
    private String state; // processing-正在审批 approved-审批已通过 refused-审批被驳回

    @Override
    public String toString() {
        return "LeaveForm{" +
                "formId=" + formId +
                ", employeeId=" + employeeId +
                ", formType=" + formType +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", reason='" + reason + '\'' +
                ", createTime=" + createTime +
                ", state='" + state + '\'' +
                '}';
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getFormType() {
        return formType;
    }

    public void setFormType(Integer formType) {
        this.formType = formType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
