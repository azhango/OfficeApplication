package pers.hua.oa.entity;

import java.util.Date;

public class ProcessFlow {
    private Long processId; //处理任务编号
    private Long formId; //表单编号
    private Long operatorId; //经办人编号
    private String action; //apply申请 audit审批
    private String result; //approved同意 refused驳回
    private String reason; //审批意见
    private Date createTime; //创建时间
    private Date auditTime; //审批时间
    private Integer orderNo; //任务序号
    private String state; //ready-准备 process-正在处理 complete-处理完成 cancel-取消
    private Integer isLast; //是否最后节点 0否 1是

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getIsLast() {
        return isLast;
    }

    public void setIsLast(Integer isLast) {
        this.isLast = isLast;
    }

    @Override
    public String toString() {
        return "ProcessFlow{" +
                "processId=" + processId +
                ", formId=" + formId +
                ", operatorId=" + operatorId +
                ", action='" + action + '\'' +
                ", result='" + result + '\'' +
                ", reason='" + reason + '\'' +
                ", createTime=" + createTime +
                ", auditTime=" + auditTime +
                ", orderNo=" + orderNo +
                ", state='" + state + '\'' +
                ", isLast=" + isLast +
                '}';
    }
}
