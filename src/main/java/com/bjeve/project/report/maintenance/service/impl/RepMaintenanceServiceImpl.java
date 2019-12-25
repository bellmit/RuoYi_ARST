package com.bjeve.project.report.maintenance.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bjeve.project.report.maintenance.mapper.RepMaintenanceMapper;
import com.bjeve.project.report.maintenance.domain.RepMaintenance;
import com.bjeve.project.report.maintenance.service.IRepMaintenanceService;
import com.bjeve.common.utils.text.Convert;

/**
 * 维修报告Service业务层处理
 * 
 * @author chaiyuming
 * @date 2019-12-25
 */
@Service
public class RepMaintenanceServiceImpl implements IRepMaintenanceService 
{
    @Autowired
    private RepMaintenanceMapper repMaintenanceMapper;

    /**
     * 查询维修报告
     * 
     * @param repId 维修报告ID
     * @return 维修报告
     */
    @Override
    public RepMaintenance selectRepMaintenanceById(String repId)
    {
        return repMaintenanceMapper.selectRepMaintenanceById(repId);
    }

    /**
     * 查询维修报告列表
     * 
     * @param repMaintenance 维修报告
     * @return 维修报告
     */
    @Override
    public List<RepMaintenance> selectRepMaintenanceList(RepMaintenance repMaintenance)
    {
        return repMaintenanceMapper.selectRepMaintenanceList(repMaintenance);
    }

    /**
     * 新增维修报告
     * 
     * @param repMaintenance 维修报告
     * @return 结果
     */
    @Override
    public int insertRepMaintenance(RepMaintenance repMaintenance)
    {
        return repMaintenanceMapper.insertRepMaintenance(repMaintenance);
    }

    /**
     * 修改维修报告
     * 
     * @param repMaintenance 维修报告
     * @return 结果
     */
    @Override
    public int updateRepMaintenance(RepMaintenance repMaintenance)
    {
        return repMaintenanceMapper.updateRepMaintenance(repMaintenance);
    }

    /**
     * 删除维修报告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRepMaintenanceByIds(String ids)
    {
        return repMaintenanceMapper.deleteRepMaintenanceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除维修报告信息
     * 
     * @param repId 维修报告ID
     * @return 结果
     */
    @Override
    public int deleteRepMaintenanceById(String repId)
    {
        return repMaintenanceMapper.deleteRepMaintenanceById(repId);
    }
}
