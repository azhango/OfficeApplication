package pers.hua.oa.mapper;

import org.apache.ibatis.annotations.Param;
import pers.hua.oa.entity.LeaveForm;

import java.util.List;
import java.util.Map;

/**
 * 请假表单
 */
public interface LeaveFormMapper {
    /**
     * 传入LeaveForm表单数据
     * @param form 请假表单
     */
    public void insert(LeaveForm form);

    /**
     * @param pfState 状态
     * @param pfOperatorId 经办人编号
     * @return 返回List集合
     */
    public List<Map> selectByParams(@Param("pf_state") String pfState
            , @Param("pf_operator_id") Long pfOperatorId);

    /**
     * 更新LeaveForm表单
     * @param form 请假表单
     */
    public void update(LeaveForm form);

    /**
     * 根据主键获取请假单对象
     * @param formId 表单id
     * @return 返回对应的请假单
     */
    public LeaveForm selectById(Long formId);
}
