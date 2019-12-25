package com.bjeve.project.report.AnesMachine.service;

import com.bjeve.project.report.AnesMachine.domain.RepAnesMachine;
import java.util.List;

/**
 * 麻醉机安装报告Service接口
 * 
 * @author chaiyuming
 * @date 2019-12-25
 */
public interface IRepAnesMachineService 
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
     * 批量删除麻醉机安装报告
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRepAnesMachineByIds(String ids);

    /**
     * 删除麻醉机安装报告信息
     * 
     * @param repId 麻醉机安装报告ID
     * @return 结果
     */
    public int deleteRepAnesMachineById(String repId);
}
