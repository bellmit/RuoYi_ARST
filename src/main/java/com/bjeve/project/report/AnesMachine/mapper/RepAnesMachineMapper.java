package com.bjeve.project.report.AnesMachine.mapper;

import com.bjeve.project.report.AnesMachine.domain.RepAnesMachine;
import java.util.List;

/**
 * 麻醉机安装报告Mapper接口
 * 
 * @author chaiyuming
 * @date 2019-12-25
 */
public interface RepAnesMachineMapper 
{
    /**
     * 查询麻醉机安装报告
     * 
     * @param repId 麻醉机安装报告ID
     * @return 麻醉机安装报告
     */
    public RepAnesMachine selectRepAnesMachineById(String repId);

    /**
     * 查询麻醉机安装报告列表
     * 
     * @param repAnesMachine 麻醉机安装报告
     * @return 麻醉机安装报告集合
     */
    public List<RepAnesMachine> selectRepAnesMachineList(RepAnesMachine repAnesMachine);

    /**
     * 新增麻醉机安装报告
     * 
     * @param repAnesMachine 麻醉机安装报告
     * @return 结果
     */
    public int insertRepAnesMachine(RepAnesMachine repAnesMachine);

    /**
     * 修改麻醉机安装报告
     * 
     * @param repAnesMachine 麻醉机安装报告
     * @return 结果
     */
    public int updateRepAnesMachine(RepAnesMachine repAnesMachine);

    /**
     * 删除麻醉机安装报告
     * 
     * @param repId 麻醉机安装报告ID
     * @return 结果
     */
    public int deleteRepAnesMachineById(String repId);

    /**
     * 批量删除麻醉机安装报告
     * 
     * @param repIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRepAnesMachineByIds(String[] repIds);
}
