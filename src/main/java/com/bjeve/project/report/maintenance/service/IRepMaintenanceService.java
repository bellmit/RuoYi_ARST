package com.bjeve.project.report.maintenance.service;

import com.bjeve.project.report.maintenance.domain.RepMaintenance;
import java.util.List;

/**
 * 维修报告Service接口
 * 
 * @author chaiyuming
 * @date 2019-12-25
 */
public interface IRepMaintenanceService 
{
    /**
     * 查询维修报告
     * 
     * @param repId 维修报告ID
     * @return 维修报告
     */
    public RepMaintenance selectRepMaintenanceById(String repId);

    /**
     * 查询维修报告列表
     * 
     * @param repMaintenance 维修报告
     * @return 维修报告集合
     */
    public List<RepMaintenance> selectRepMaintenanceList(RepMaintenance repMaintenance);

    /**
     * 新增维修报告
     * 
     * @param repMaintenance 维修报告
     * @return 结果
     */
    public int insertRepMaintenance(RepMaintenance repMaintenance);

    /**
     * 修改维修报告
     * 
     * @param repMaintenance 维修报告
     * @return 结果
     */
    public int updateRepMaintenance(RepMaintenance repMaintenance);

    /**
     * 批量删除维修报告
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRepMaintenanceByIds(String ids);

    /**
     * 删除维修报告信息
     * 
     * @param repId 维修报告ID
     * @return 结果
     */
    public int deleteRepMaintenanceById(String repId);
}
