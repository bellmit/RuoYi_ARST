package com.bjeve.project.report.ventilator.service;

import com.bjeve.project.report.ventilator.domain.RepVentilator;
import java.util.List;

/**
 * 呼吸机安装报告Service接口
 * 
 * @author chaiyuming
 * @date 2019-12-25
 */
public interface IRepVentilatorService 
{
    /**
     * 查询呼吸机安装报告
     * 
     * @param repId 呼吸机安装报告ID
     * @return 呼吸机安装报告
     */
    public RepVentilator selectRepVentilatorById(String repId);

    /**
     * 查询呼吸机安装报告列表
     * 
     * @param repVentilator 呼吸机安装报告
     * @return 呼吸机安装报告集合
     */
    public List<RepVentilator> selectRepVentilatorList(RepVentilator repVentilator);

    /**
     * 新增呼吸机安装报告
     * 
     * @param repVentilator 呼吸机安装报告
     * @return 结果
     */
    public int insertRepVentilator(RepVentilator repVentilator);

    /**
     * 修改呼吸机安装报告
     * 
     * @param repVentilator 呼吸机安装报告
     * @return 结果
     */
    public int updateRepVentilator(RepVentilator repVentilator);

    /**
     * 批量删除呼吸机安装报告
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRepVentilatorByIds(String ids);

    /**
     * 删除呼吸机安装报告信息
     * 
     * @param repId 呼吸机安装报告ID
     * @return 结果
     */
    public int deleteRepVentilatorById(String repId);
}
