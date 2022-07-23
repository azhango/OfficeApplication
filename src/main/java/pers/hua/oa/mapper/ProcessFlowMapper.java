package pers.hua.oa.mapper;

import pers.hua.oa.entity.ProcessFlow;

import java.util.List;

/**
 * 请假单处理流程
 */
public interface ProcessFlowMapper {
    /**
     * 写入请假单处理流程
     * @param processFlow 请假单流程
     */
    public void insert(ProcessFlow processFlow);

    /**
     * 更新处理流程
     * @param processFlow 传入审批后的请假单
     */
    public void update(ProcessFlow processFlow);

    public List<ProcessFlow> selectByFormId(Long formId);
}
