package com.bjeve.project.report.ventilator.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bjeve.project.report.ventilator.mapper.RepVentilatorMapper;
import com.bjeve.project.report.ventilator.domain.RepVentilator;
import com.bjeve.project.report.ventilator.service.IRepVentilatorService;
import com.bjeve.common.utils.text.Convert;

/**
 * 呼吸机安装报告Service业务层处理
 * 
 * @author chaiyuming
 * @date 2019-12-25
 */
@Service
public class RepVentilatorServiceImpl implements IRepVentilatorService 
{
    @Autowired
    private RepVentilatorMapper repVentilatorMapper;

    /**
     * 查询呼吸机安装报告
     * 
     * @param repId 呼吸机安装报告ID
     * @return 呼吸机安装报告
     */
    @Override
    public RepVentilator selectRepVentilatorById(String repId)
    {
        return repVentilatorMapper.selectRepVentilatorById(repId);
    }

    /**
     * 查询呼吸机安装报告列表
     * 
     * @param repVentilator 呼吸机安装报告
     * @return 呼吸机安装报告
     */
    @Override
    public List<RepVentilator> selectRepVentilatorList(RepVentilator repVentilator)
    {
        return repVentilatorMapper.selectRepVentilatorList(repVentilator);
    }

    /**
     * 新增呼吸机安装报告
     * 
     * @param repVentilator 呼吸机安装报告
     * @return 结果
     */
    @Override
    public int insertRepVentilator(RepVentilator repVentilator)
    {
        return repVentilatorMapper.insertRepVentilator(repVentilator);
    }

    /**
     * 修改呼吸机安装报告
     * 
     * @param repVentilator 呼吸机安装报告
     * @return 结果
     */
    @Override
    public int updateRepVentilator(RepVentilator repVentilator)
    {
        return repVentilatorMapper.updateRepVentilator(repVentilator);
    }

    /**
     * 删除呼吸机安装报告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRepVentilatorByIds(String ids)
    {
        return repVentilatorMapper.deleteRepVentilatorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除呼吸机安装报告信息
     * 
     * @param repId 呼吸机安装报告ID
     * @return 结果
     */
    @Override
    public int deleteRepVentilatorById(String repId)
    {
        return repVentilatorMapper.deleteRepVentilatorById(repId);
    }
}
