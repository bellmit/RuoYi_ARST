package com.bjeve.project.report.AnesMachine.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bjeve.project.report.AnesMachine.mapper.RepAnesMachineMapper;
import com.bjeve.project.report.AnesMachine.domain.RepAnesMachine;
import com.bjeve.project.report.AnesMachine.service.IRepAnesMachineService;
import com.bjeve.common.utils.text.Convert;

/**
 * 麻醉机安装报告Service业务层处理
 * 
 * @author chaiyuming
 * @date 2019-12-25
 */
@Service
public class RepAnesMachineServiceImpl implements IRepAnesMachineService 
{
    @Autowired
    private RepAnesMachineMapper repAnesMachineMapper;

    /**
     * 查询麻醉机安装报告
     * 
     * @param repId 麻醉机安装报告ID
     * @return 麻醉机安装报告
     */
    @Override
    public RepAnesMachine selectRepAnesMachineById(String repId)
    {
        return repAnesMachineMapper.selectRepAnesMachineById(repId);
    }

    /**
     * 查询麻醉机安装报告列表
     * 
     * @param repAnesMachine 麻醉机安装报告
     * @return 麻醉机安装报告
     */
    @Override
    public List<RepAnesMachine> selectRepAnesMachineList(RepAnesMachine repAnesMachine)
    {
        return repAnesMachineMapper.selectRepAnesMachineList(repAnesMachine);
    }

    /**
     * 新增麻醉机安装报告
     * 
     * @param repAnesMachine 麻醉机安装报告
     * @return 结果
     */
    @Override
    public int insertRepAnesMachine(RepAnesMachine repAnesMachine)
    {
        return repAnesMachineMapper.insertRepAnesMachine(repAnesMachine);
    }

    /**
     * 修改麻醉机安装报告
     * 
     * @param repAnesMachine 麻醉机安装报告
     * @return 结果
     */
    @Override
    public int updateRepAnesMachine(RepAnesMachine repAnesMachine)
    {
        return repAnesMachineMapper.updateRepAnesMachine(repAnesMachine);
    }

    /**
     * 删除麻醉机安装报告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRepAnesMachineByIds(String ids)
    {
        return repAnesMachineMapper.deleteRepAnesMachineByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除麻醉机安装报告信息
     * 
     * @param repId 麻醉机安装报告ID
     * @return 结果
     */
    @Override
    public int deleteRepAnesMachineById(String repId)
    {
        return repAnesMachineMapper.deleteRepAnesMachineById(repId);
    }
}
